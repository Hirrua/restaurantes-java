package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @Column(nullable = false, length = 50)
    private String street;

    @Column(nullable = false, length = 20)
    private String city;

    @Column(nullable = false, length = 20)
    private String state;

    @Column(length = 50)
    private String complement;

    @JsonProperty("postal_code")
    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    @Column(nullable = false, length = 20)
    private String country;
}



