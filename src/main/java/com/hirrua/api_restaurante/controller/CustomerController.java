package com.hirrua.api_restaurante.controller;

import com.hirrua.api_restaurante.dtos.customer.CustomerDocumentRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerResponseDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerUpdateRequestDto;
import com.hirrua.api_restaurante.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequestDto customer) {
        var customerId = customerService.create(customer);
        return ResponseEntity.created(URI.create("v1/customers/" + customerId)).body("Customer was create!");
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomerById(@PathVariable(value = "id") Long id, @RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) {
        try {
            customerService.update(id, customerUpdateRequestDto);
            return ResponseEntity.ok("Customer was update");
        } catch (NoSuchElementException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/document")
    public ResponseEntity<CustomerResponseDto> getCustomerByDocument(@RequestBody @Valid CustomerDocumentRequestDto customerDocumentRequestDto) {
        try {
            return ResponseEntity.ok(customerService.findByDocument(customerDocumentRequestDto.getDocument()));
        } catch (NoSuchElementException err) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id) {
        try {
            customerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException err) {
            return ResponseEntity.badRequest().build();
        }
    }
}
