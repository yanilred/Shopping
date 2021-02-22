package com.tcs.shopping.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tcs.shopping.entities.ProductEntity;



public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
   
	List<ProductEntity> findByIdIn(List<Long> prdIds);

}