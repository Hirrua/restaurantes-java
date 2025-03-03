package com.hirrua.api_restaurante.repositories;

import com.hirrua.api_restaurante.domain.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {

    Optional<RestaurantEntity> findByCategory(String category);

    @Query("SELECT r FROM RestaurantEntity r LEFT JOIN FETCH r.menuItems WHERE r.id = :id")
    Optional<RestaurantEntity> findByIdWithMenuItems(@Param("id") Long id);
}
