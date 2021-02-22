package com.tcs.shopping.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.shopping.daos.ProductRepo;
import com.tcs.shopping.entities.ProductEntity;
import com.tcs.shopping.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Iterable<ProductEntity> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public ProductEntity getProduct(long id) {
        return productRepo
          .findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("ProductEntity not found"));
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepo.save(product);
    }
}