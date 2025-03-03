package com.hirrua.api_restaurante.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerOrderResponseDto(
        Long id,
        @JsonProperty("full_name")
        String fullName
) {
}
