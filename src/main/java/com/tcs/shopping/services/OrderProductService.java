package com.tcs.shopping.services;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tcs.shopping.entities.OrderProductEntity;
@Service
@Validated
public interface OrderProductService {

    OrderProductEntity create(@NotNull(message = "The products should not be null for the order.") 
    @Valid OrderProductEntity orderProduct);
}