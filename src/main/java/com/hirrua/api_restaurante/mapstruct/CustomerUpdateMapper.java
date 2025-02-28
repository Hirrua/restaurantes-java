package com.hirrua.api_restaurante.mapstruct;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.dtos.customer.CustomerUpdateRequestDto;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerUpdateMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "id", ignore = true)
    CustomerEntity toCustomerUpdateEntity(CustomerUpdateRequestDto customerUpdateRequestDto, @MappingTarget CustomerEntity customerEntity);
}
