package com.tcs.shopping.services;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tcs.shopping.entities.OrderEntity;
@Service
@Validated
public interface OrderService {

    @NotNull List<OrderEntity> getAllOrders();
    
    @NotNull OrderEntity findById(Long id);

    OrderEntity create(@NotNull(message = "The order should not be null.") @Valid OrderEntity order);

    void update(@NotNull(message = "The order should be null.") @Valid OrderEntity order);
    
    OrderEntity findByIdAndFetchProductsEagerly(Long id);
}