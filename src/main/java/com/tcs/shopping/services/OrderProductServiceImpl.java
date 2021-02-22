package com.tcs.shopping.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.shopping.daos.OrderProductRepository;
import com.tcs.shopping.entities.OrderProductEntity;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProductEntity create(OrderProductEntity orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}