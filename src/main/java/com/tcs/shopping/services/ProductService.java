package com.tcs.shopping.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.shopping.daos.ProductRepo;
import com.tcs.shopping.entities.ProductEntity;


@Service
@Transactional
public class ProductService{

	@Autowired
    private ProductRepo productRepository;

   

   
    public List<ProductEntity> getAllProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    
    public ProductEntity getProduct(long id) {
    	//ModelMapper modelMapper = new ModelMapper();
        return (ProductEntity) productRepository
          .findById(id).get();
    }

    
    public ProductEntity save(ProductEntity product) {
        return (ProductEntity) productRepository.save(product);
    }
}
