package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hirrua.api_restaurante.domain.enums.RestaurantCategoryEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_restaurant")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private RestaurantCategoryEnum category;

    @Column(nullable = true)
    private Integer rating;

    @Column(nullable = false)
    private boolean delivery;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "restaurant")
    @JsonManagedReference
    private List<MenuItemEntity> menuItems = new ArrayList<>();
}
