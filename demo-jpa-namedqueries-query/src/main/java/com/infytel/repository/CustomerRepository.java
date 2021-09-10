package com.infytel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infytel.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("select cus from Customer cus where cus.address = ?1")
	Customer findByAddress(String address);
	
}
