package com.tcs.shopping.daos;

import org.springframework.data.repository.CrudRepository;

import com.tcs.shopping.entities.OrderProductEntity;
import com.tcs.shopping.entities.OrderProductRelation;

public interface OrderProductRepository extends CrudRepository<OrderProductEntity, OrderProductRelation> {
}