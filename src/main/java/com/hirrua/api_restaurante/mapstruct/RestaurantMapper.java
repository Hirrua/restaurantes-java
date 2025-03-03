package com.hirrua.api_restaurante.mapstruct;

import com.hirrua.api_restaurante.domain.entities.RestaurantEntity;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantOrderResponseDto;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantRequestDto;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = MenuItemMapper.class)
public interface RestaurantMapper {

    @Mapping(target = "menuItems", ignore = true)
    @Mapping(target = "id", ignore = true)
    RestaurantEntity toRestaurantEntity(RestaurantRequestDto dto);

    @Mapping(target = "menuItems", source = "menuItems")
    RestaurantResponseDto toRestaurantResponseDto(RestaurantEntity entity);

    List<RestaurantResponseDto> toListRestaurantResponseDto(List<RestaurantEntity> entities);

    RestaurantOrderResponseDto toRestaurantOrderResponseDto(RestaurantEntity entity);
}
