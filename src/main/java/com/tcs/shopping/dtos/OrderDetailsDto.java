package com.tcs.shopping.dtos;

import com.tcs.shopping.entities.ProductEntity;

public class OrderDetailsDto {

    private ProductEntity product;
    private Integer quantity;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}