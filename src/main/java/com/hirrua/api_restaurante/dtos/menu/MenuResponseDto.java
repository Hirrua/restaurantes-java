package com.hirrua.api_restaurante.dtos.menu;

import java.math.BigDecimal;

public record MenuResponseDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        boolean available
) {
}
