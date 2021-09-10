package com.infytel.repository;

import com.infytel.entity.Customer;

public interface CustomerDAO {
	// Method to insert a Customer record into the db
    public void insert(Customer customer);
    
    // Method to update a Customer record into the db
    public void update(Customer customer);
    
  //Method to get a Customer record based on Phone number
    public Customer getCustomer(Long phoneNo);
   

}
