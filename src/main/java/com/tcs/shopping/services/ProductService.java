package com.tcs.shopping.services;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.tcs.shopping.entities.ProductEntity;

@Validated
@Service
public interface ProductService {

    @NotNull Iterable<ProductEntity> getAllProducts();

    ProductEntity getProduct(@Min(value = 1L, message = "Invalid product ID.") long id);

    ProductEntity save(ProductEntity product);
}