package com.tcs.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.shopping.entities.CustomersEntity;
import com.tcs.shopping.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<CustomersEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }
	
	@GetMapping("/customers/{customerId}")
	public CustomersEntity getCustomerById(@PathVariable Long customerId) {
        return  customerService.getCustomerById(customerId);
    }
}
