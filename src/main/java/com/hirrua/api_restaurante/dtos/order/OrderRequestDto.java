package com.hirrua.api_restaurante.dtos.order;

public record OrderRequestDto(
        Long customer,
        Long menuItem
) {
}
