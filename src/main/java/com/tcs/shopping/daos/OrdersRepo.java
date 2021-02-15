package com.tcs.shopping.daos;

import org.springframework.data.repository.CrudRepository;

import com.tcs.shopping.entities.OrderEntity;


public interface OrdersRepo extends CrudRepository<OrderEntity, Long> {
    //List<CustomersEntity> findByFirstName(String firstName);
}