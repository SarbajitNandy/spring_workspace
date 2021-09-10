package com.infytel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	 @Transactional
	   /* clearAutomatically = true is to clear entity manager automatically, drop all pending changes
	   that have not been flushed to database yet. This attribute should be used carefully otherwise will lose any pending
	   changes*/
	   @Modifying(clearAutomatically = true)
	   @Query(value="INSERT into Customer(phone_no,name,age,gender,address) values (7022713753, 'Alex', 27, 'M', 'Chicago')", nativeQuery = true)
	   void insert();        
	   
	   @Transactional
	   @Modifying
	   @Query(value = "update  Customer set address = ? " + " where phone_no = ?", nativeQuery = true)
	   void addressUpdate(String address,long phoneNumber);
}
