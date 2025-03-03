package com.hirrua.api_restaurante.service;

import com.hirrua.api_restaurante.dtos.order.OrderDetailsResponseDto;
import com.hirrua.api_restaurante.dtos.order.OrderRequestDto;
import com.hirrua.api_restaurante.mapstruct.OrderMapper;
import com.hirrua.api_restaurante.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Transactional
    public OrderDetailsResponseDto create(OrderRequestDto orderRequestDto) {
        return orderMapper.toOrderDetailsResponseDto(orderRepository.save(orderMapper.toOrderEntity(orderRequestDto)));
    }

}
