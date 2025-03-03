package com.hirrua.api_restaurante.mapstruct;

import com.hirrua.api_restaurante.domain.entities.MenuItemEntity;
import com.hirrua.api_restaurante.dtos.menu.MenuResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MenuItemMapper {

    MenuResponseDto toMenuResponseDto(MenuItemEntity entity);
}
