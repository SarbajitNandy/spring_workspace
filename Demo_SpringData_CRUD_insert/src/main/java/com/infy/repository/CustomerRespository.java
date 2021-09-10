package com.infy.repository;


import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infy.entity.Customer;


public interface CustomerRespository extends CrudRepository<Customer, Integer> {
	@Query("SELECT c.emailId FROM Customer c WHERE c.customerId = :customerId")
	public String findEmailById( @Param("customerId") Integer customerId );
	
	public LocalDate findDOBById(@Param("customerId") Integer customerId);
	
	Optional<Customer> findByEmailId(String emailId);
	
}
