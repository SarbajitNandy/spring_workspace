package com.infytel.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.infytel.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
	
}
