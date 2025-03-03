package com.hirrua.api_restaurante.dtos.order;

import com.hirrua.api_restaurante.dtos.customer.CustomerOrderResponseDto;
import com.hirrua.api_restaurante.dtos.menu.MenuResponseDto;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantOrderResponseDto;

import java.time.LocalDateTime;

public record OrderDetailsResponseDto(
        Long id,
        LocalDateTime orderDate,
        CustomerOrderResponseDto customer,
        MenuResponseDto menuItem,
        RestaurantOrderResponseDto responseDto
) {
}
