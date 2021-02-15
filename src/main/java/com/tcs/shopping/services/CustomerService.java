package com.tcs.shopping.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.shopping.daos.CustomerRepo;
import com.tcs.shopping.entities.CustomersEntity;


@Service
@Transactional
public class CustomerService{

	@Autowired
    private CustomerRepo customerRepo;

   

   
    public List<CustomersEntity> getAllCustomers() {
        return (List<CustomersEntity>) customerRepo.findAll();
    }

    
    public CustomersEntity getCustomerById(long id) {
    	//ModelMapper modelMapper = new ModelMapper();
        return (CustomersEntity) customerRepo
          .findById(id).get();
    }

    
    public CustomersEntity save(CustomersEntity product) {
        return (CustomersEntity) customerRepo.save(product);
    }
}
