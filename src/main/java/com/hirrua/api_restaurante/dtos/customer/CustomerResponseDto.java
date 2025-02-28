package com.hirrua.api_restaurante.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hirrua.api_restaurante.domain.entities.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("mobile_phone")
    private String mobilePhone;
    private String email;
    private String document;
    private Address address;
}
