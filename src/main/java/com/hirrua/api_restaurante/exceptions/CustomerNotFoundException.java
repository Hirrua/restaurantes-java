package com.hirrua.api_restaurante.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() { super("Customer not found!"); }
}
