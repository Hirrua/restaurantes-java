package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.dtos.restaurant.RestaurantRequestDto;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantResponseDto;
import com.hirrua.api_restaurante.exceptions.EntityNotFoundException;
import com.hirrua.api_restaurante.mapstruct.RestaurantMapper;
import com.hirrua.api_restaurante.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Transactional
    public Long create(RestaurantRequestDto restaurantRequestDto) {
        var restaurantEntity = restaurantMapper.toRestaurantEntity(restaurantRequestDto);
        restaurantRepository.save(restaurantEntity);
        return restaurantEntity.getId();
    }

    @Transactional(readOnly = true)
    public RestaurantResponseDto findRestaurants(Long id) throws EntityNotFoundException {
        var entities = restaurantRepository.findByIdWithMenuItems(id).orElseThrow(() -> new EntityNotFoundException("Restaurant not found."));
        return restaurantMapper.toRestaurantResponseDto(entities);
    }

}
