package com.hirrua.api_restaurante.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "db_order")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItemEntity menuItem;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate = LocalDateTime.now();
}
