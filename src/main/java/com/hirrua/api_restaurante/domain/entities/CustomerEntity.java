package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "tb_customer")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("full_name")
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;

    @JsonProperty("mobile_phone")
    @Column(name = "mobile_phone", length = 11)
    private String mobilePhone;

    @Email
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 11, unique = true)
    private String document;

    @Embedded
    private Address address;
}
