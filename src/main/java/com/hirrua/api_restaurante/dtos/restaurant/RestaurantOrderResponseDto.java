package com.hirrua.api_restaurante.dtos.restaurant;

import com.hirrua.api_restaurante.domain.enums.RestaurantCategoryEnum;

public record RestaurantOrderResponseDto(
        String name,
        RestaurantCategoryEnum category,
        boolean delivery,
        Integer rating
) {
}
