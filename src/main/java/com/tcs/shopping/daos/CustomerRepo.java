package com.tcs.shopping.daos;

import org.springframework.data.repository.CrudRepository;
import com.tcs.shopping.entities.CustomersEntity;

public interface CustomerRepo extends CrudRepository<CustomersEntity, Long> {
	    //List<CustomersEntity> findByFirstName(String firstName);
	}


