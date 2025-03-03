package com.hirrua.api_restaurante.dtos.restaurant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hirrua.api_restaurante.domain.entities.Address;
import com.hirrua.api_restaurante.domain.enums.RestaurantCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequestDto {

    @JsonProperty(required = true)
    private String name;
    @JsonProperty(required = true)
    private String description;
    @JsonProperty(required = true)
    private RestaurantCategoryEnum category;
    private Integer rating;
    @JsonProperty(required = true)
    private boolean delivery;
    @JsonProperty(required = true)
    private Address address;
}
