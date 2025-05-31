package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hirrua.api_restaurante.domain.enums.TypeUserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_customer")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerEntity implements UserDetails {

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

    @Enumerated(value = EnumType.STRING)
    private String role = TypeUserRoleEnum.ROLE_CUSTOMER.name();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
