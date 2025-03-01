package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.dtos.customer.CustomerRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerResponseDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerUpdateRequestDto;
import com.hirrua.api_restaurante.exceptions.CustomerNotFoundException;
import com.hirrua.api_restaurante.exceptions.NoDataAvailableException;
import com.hirrua.api_restaurante.mapstruct.CustomerMapper;
import com.hirrua.api_restaurante.mapstruct.CustomerUpdateMapper;
import com.hirrua.api_restaurante.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerUpdateMapper customerUpdateMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, CustomerUpdateMapper customerUpdateMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.customerUpdateMapper = customerUpdateMapper;
    }

    @Transactional
    public Long create(CustomerRequestDto customer) {
        var customerEntity = customerMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
        return customerEntity.getId();
    }

    public List<CustomerResponseDto> findAllCustomers() throws NoDataAvailableException {
        List<CustomerEntity> customerEntity = customerRepository.findAll();

        if (customerEntity.isEmpty()) {
            throw new NoDataAvailableException();
        }

        return customerMapper.toListCustomerResponseDto(customerEntity);
    }

    public CustomerResponseDto findById(Long id) throws CustomerNotFoundException {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(CustomerNotFoundException::new);
    }

    public CustomerResponseDto findByDocument(String document) throws CustomerNotFoundException {
        return customerRepository.findByDocument(document)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(CustomerNotFoundException::new);
    }

    @Transactional
    public void update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {
        var customerEntity = customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        var customerUpdateEntity = customerUpdateMapper.toCustomerUpdateEntity(customerUpdateRequestDto, customerEntity);
        customerRepository.save(customerUpdateEntity);
    }

    @Transactional
    public void delete(Long id) throws CustomerNotFoundException {
        customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        customerRepository.deleteById(id);
    }
}
