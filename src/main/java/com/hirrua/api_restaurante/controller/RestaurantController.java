package com.hirrua.api_restaurante.controller;

import com.hirrua.api_restaurante.dtos.restaurant.RestaurantRequestDto;
import com.hirrua.api_restaurante.dtos.restaurant.RestaurantResponseDto;
import com.hirrua.api_restaurante.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) { this.restaurantService = restaurantService; }

    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody @Valid RestaurantRequestDto restaurantRequestDto) {
        var restaurantId = restaurantService.create(restaurantRequestDto);
        return ResponseEntity.created(URI.create("/v1/restaurants/" + restaurantId)).body("Restaurant was create");
    }

    @GetMapping("/{id}")
    public RestaurantResponseDto getRestaurant(@PathVariable(value = "id") Long id) {
        return restaurantService.findRestaurants(id);
    }

}
