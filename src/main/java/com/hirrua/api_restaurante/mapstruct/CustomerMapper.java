package com.hirrua.api_restaurante.mapstruct;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.dtos.customer.CustomerRequestDto;
import com.hirrua.api_restaurante.dtos.customer.CustomerResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    CustomerEntity toCustomerEntity(CustomerRequestDto dto);

    CustomerResponseDto toCustomerResponseDto(CustomerEntity entity);

    List<CustomerResponseDto> toListCustomerResponseDto (List<CustomerEntity> entityList);
}
