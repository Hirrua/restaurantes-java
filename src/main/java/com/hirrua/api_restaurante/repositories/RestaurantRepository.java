package com.hirrua.api_restaurante.repositories;

import com.hirrua.api_restaurante.domain.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByCategory(String category);
}
