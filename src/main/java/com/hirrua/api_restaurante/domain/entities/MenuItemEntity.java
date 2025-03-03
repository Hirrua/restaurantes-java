package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "db_menu_item")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @Positive(message = "Price must be a positive value")
    @Column(nullable = false)
    private BigDecimal price;

    private boolean available = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference
    private RestaurantEntity restaurant;

    @OneToMany(mappedBy = "menuItem")
    @JsonIgnore
    private List<OrderEntity> orderItems = new ArrayList<>();
}
