package com.hirrua.api_restaurante.controller;

import com.hirrua.api_restaurante.dtos.order.OrderDetailsResponseDto;
import com.hirrua.api_restaurante.dtos.order.OrderRequestDto;
import com.hirrua.api_restaurante.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDetailsResponseDto makeAnOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.create(orderRequestDto);
    }

}
