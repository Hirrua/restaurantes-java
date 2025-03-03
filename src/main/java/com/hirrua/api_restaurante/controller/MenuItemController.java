package com.hirrua.api_restaurante.controller;

import com.hirrua.api_restaurante.dtos.menu.MenuRequestDto;
import com.hirrua.api_restaurante.dtos.menu.MenuResponseDto;
import com.hirrua.api_restaurante.service.MenuItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/menu")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping
    public ResponseEntity<MenuResponseDto> createMenu(@RequestBody @Valid MenuRequestDto menuRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuItemService.create(menuRequestDto));
    }
}
