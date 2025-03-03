package com.hirrua.api_restaurante.dtos.menu;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record MenuRequestDto(
        @NotBlank String name,
        @NotBlank String description,
        @Positive BigDecimal price,
        @NotNull boolean available,
        @NotNull Long restaurantId
) {}