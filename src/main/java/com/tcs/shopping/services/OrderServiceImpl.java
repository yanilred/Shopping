package com.tcs.shopping.services;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.shopping.daos.OrdersRepo;
import com.tcs.shopping.entities.OrderEntity;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrdersRepo orderRepository;

    public OrderServiceImpl(OrdersRepo orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderEntity> getAllOrders() {
        return (List<OrderEntity>) this.orderRepository.findAll();
    }
    
    public OrderEntity findById(Long id) {
    	return (OrderEntity) this.orderRepository.findById(id).get();
    }

    @Override
    public OrderEntity create(OrderEntity order) {
        order.setCreatedOn(new Date());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(OrderEntity order) {
        this.orderRepository.save(order);
    }
    
    public  OrderEntity findByIdAndFetchProductsEagerly(Long id) {
    	 return null;//this.orderRepository.findByIdAndFetchProductsEagerly(id);
    }
}