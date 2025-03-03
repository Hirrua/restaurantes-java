package com.hirrua.api_restaurante.repositories;

import com.hirrua.api_restaurante.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
