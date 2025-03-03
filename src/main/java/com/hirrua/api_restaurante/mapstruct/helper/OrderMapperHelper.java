package com.hirrua.api_restaurante.mapstruct.helper;

import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import com.hirrua.api_restaurante.domain.entities.MenuItemEntity;
import com.hirrua.api_restaurante.exceptions.EntityNotFoundException;
import com.hirrua.api_restaurante.repositories.CustomerRepository;
import com.hirrua.api_restaurante.repositories.MenuItemRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperHelper {

    private final CustomerRepository customerRepository;
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public OrderMapperHelper(CustomerRepository customerRepository, MenuItemRepository menuItemRepository) {
        this.customerRepository = customerRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Named("mapCustomerId")
    public CustomerEntity mapCustomerId(Long customerId) throws EntityNotFoundException {
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new EntityNotFoundException("Customer not found."));
    }

    @Named("mapMenuItemId")
    public MenuItemEntity mapMenuItemId(Long menuItemId) throws EntityNotFoundException {
        return menuItemRepository.findByIdWithRestaurant(menuItemId)
                .orElseThrow(()-> new EntityNotFoundException("Menu not found."));
    }
}
