package com.hirrua.api_restaurante.dtos.customer;

public record CustomerLoginRequest(
        String email,
        String password
) {
}
