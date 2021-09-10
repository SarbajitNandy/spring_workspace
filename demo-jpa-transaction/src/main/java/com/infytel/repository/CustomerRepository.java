package com.infytel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infytel.entity.Customer;
import com.infytel.entity.Plan;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Method to update a Customer record into the db
	 @Transactional
	@Modifying
	 @Query(value = "update  Customer set plan_name = ? " + " where phone_No = ?", nativeQuery = true)
	 public void customerUpdate(Plan plan, long phoneNumber);

   

}
