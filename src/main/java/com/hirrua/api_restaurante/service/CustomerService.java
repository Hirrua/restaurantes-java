package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.dtos.customer.CustomerRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerResponseDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerUpdateRequestDto;
import com.hirrua.api_restaurante.mapstruct.CustomerMapper;
import com.hirrua.api_restaurante.mapstruct.CustomerUpdateMapper;
import com.hirrua.api_restaurante.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    public List<CustomerResponseDto> findAllCustomers() {
        List<CustomerEntity> customerEntity = customerRepository.findAll();
        return customerMapper.toListCustomerResponseDto(customerEntity);
    }

    public CustomerResponseDto findById(Long id){
        return customerRepository.findById(id)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(NoSuchElementException::new);
    }

    public void update(Long id, CustomerUpdateRequestDto customerUpdateRequestDto) throws NoSuchElementException {
        var customerEntity = customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var customerUpdateEntity = customerUpdateMapper.toCustomerUpdateEntity(customerUpdateRequestDto, customerEntity);
        customerRepository.save(customerUpdateEntity);
    }

    public CustomerResponseDto findByDocument(String document) throws NoSuchElementException {
        return customerRepository.findByDocument(document)
                .map(customerMapper::toCustomerResponseDto)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public void delete(Long id) throws NoSuchElementException {
        customerRepository.findById(id).orElseThrow(NoSuchElementException::new);
        customerRepository.deleteById(id);
    }
}
