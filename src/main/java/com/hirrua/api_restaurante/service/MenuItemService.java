package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.domain.entities.MenuItemEntity;
import com.hirrua.api_restaurante.domain.entities.RestaurantEntity;
import com.hirrua.api_restaurante.dtos.menu.MenuRequestDto;
import com.hirrua.api_restaurante.dtos.menu.MenuResponseDto;
import com.hirrua.api_restaurante.exceptions.EntityNotFoundException;
import com.hirrua.api_restaurante.repositories.MenuItemRepository;
import com.hirrua.api_restaurante.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    public MenuResponseDto create(MenuRequestDto menuRequestDto) {
        RestaurantEntity restaurant = restaurantRepository.findById(menuRequestDto.restaurantId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found."));

        MenuItemEntity menuItem = new MenuItemEntity();
        menuItem.setName(menuRequestDto.name());
        menuItem.setDescription(menuRequestDto.description());
        menuItem.setPrice(menuRequestDto.price());
        menuItem.setAvailable(menuRequestDto.available());
        menuItem.setRestaurant(restaurant);

        MenuItemEntity savedItem = menuItemRepository.save(menuItem);

        return new MenuResponseDto(
                savedItem.getId(),
                savedItem.getName(),
                savedItem.getDescription(),
                savedItem.getPrice(),
                savedItem.isAvailable()
        );
    }

}
