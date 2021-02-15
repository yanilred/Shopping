package com.tcs.shopping.daos;

import org.springframework.data.repository.CrudRepository;

import com.tcs.shopping.entities.ProductEntity;



public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    //List<CustomersEntity> findByFirstName(String firstName);
}