package com.hirrua.api_restaurante.mapstruct;

import com.hirrua.api_restaurante.domain.entities.OrderEntity;
import com.hirrua.api_restaurante.dtos.order.OrderDetailsResponseDto;
import com.hirrua.api_restaurante.dtos.order.OrderRequestDto;
import com.hirrua.api_restaurante.mapstruct.helper.OrderMapperHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        uses = OrderMapperHelper.class )
public interface OrderMapper {

    @Mapping(target = "responseDto", source = "menuItem.restaurant")
    OrderDetailsResponseDto toOrderDetailsResponseDto(OrderEntity entity);

    @Mapping(target = "orderDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", source = "customer", qualifiedByName = "mapCustomerId")
    @Mapping(target = "menuItem", source = "menuItem", qualifiedByName = "mapMenuItemId")
    OrderEntity toOrderEntity(OrderRequestDto dto);
}
