package com.hirrua.api_restaurante.repositories;

import com.hirrua.api_restaurante.domain.entities.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {

    @Query("SELECT m FROM MenuItemEntity m JOIN FETCH m.restaurant WHERE m.id = :id")
    Optional<MenuItemEntity> findByIdWithRestaurant(@Param("id") Long id);
}
