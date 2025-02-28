package com.hirrua.api_restaurante.dtos.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hirrua.api_restaurante.domain.entities.Address;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDto {

    @JsonProperty(value = "full_name", required = true)
    private String fullName;
    @JsonProperty(value = "mobile_phone", required = true)
    private String mobilePhone;
    @Email
    @JsonProperty(required = true)
    private String email;
    @JsonProperty(required = true)
    private String password;
    @JsonProperty(required = true)
    private String document;
    @JsonProperty(required = true)
    private Address address;
}
