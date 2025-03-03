package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.dtos.customer.CustomerRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerResponseDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerUpdateRequestDto;
import com.hirrua.api_restaurante.exceptions.EntityNotFoundException;
import com.hirrua.api_restaurante.exceptions.NoDataAvailableException;
import com.hirrua.api_restaurante.mapstruct.CustomerMapper;
import com.hirrua.api_restaurante.mapstruct.CustomerUpdateMapper;
import com.hirrua.api_restaurante.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerUpdateMapper customerUpdateMapper;

    @Autowired
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

    public CustomerResponseDto findById(Long id) throws EntityNotFoundException {
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found."));
    }

    public CustomerResponseDto findByDocument(String document) throws EntityNotFoundException {
        return customerRepository.findByDocument(document)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found."));
    }

    @Transactional
    public void update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) throws EntityNotFoundException {
        var customerEntity = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found."));
        var customerUpdateEntity = customerUpdateMapper.toCustomerUpdateEntity(customerUpdateRequestDto, customerEntity);
        customerRepository.save(customerUpdateEntity);
    }

    @Transactional
    public void delete(Long id) throws EntityNotFoundException {
        customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not found."));
        customerRepository.deleteById(id);
    }
}
