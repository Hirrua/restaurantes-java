package com.hirrua.api_restaurante.dtos.restaurant;

import com.hirrua.api_restaurante.domain.entities.Address;
import com.hirrua.api_restaurante.domain.entities.MenuItemEntity;
import com.hirrua.api_restaurante.domain.enums.RestaurantCategoryEnum;
import com.hirrua.api_restaurante.dtos.menu.MenuResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantResponseDto {

    private String name;
    private String description;
    private RestaurantCategoryEnum category;
    private Integer rating;
    private boolean delivery;
    private List<MenuResponseDto> menuItems;
}
