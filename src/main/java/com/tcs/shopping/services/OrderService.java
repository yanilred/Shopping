package com.tcs.shopping.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.shopping.daos.OrdersRepo;
import com.tcs.shopping.entities.OrderEntity;


@Service
@Transactional
public class OrderService{

	@Autowired
    private OrdersRepo ordersRepo;

   

   
    public List<OrderEntity> getAllProducts() {
        return (List<OrderEntity>) ordersRepo.findAll();
    }

    
    public OrderEntity getProduct(long id) {
    	//ModelMapper modelMapper = new ModelMapper();
        return (OrderEntity) ordersRepo
          .findById(id).get();
    }

    
    public OrderEntity save(OrderEntity product) {
        return (OrderEntity) ordersRepo.save(product);
    }
}
