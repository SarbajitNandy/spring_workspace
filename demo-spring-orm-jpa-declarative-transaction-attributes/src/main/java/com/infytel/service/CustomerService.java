package com.infytel.service;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {
	// Method to access the repository layer method to insert Customer record
	public void insert(CustomerDTO customerDTO);

	 // Method to update a Customer record into the db
    public void update(CustomerDTO customerDTO);
    
    //Method to get a Customer record based on Phone number
     public CustomerDTO getCustomer(Long phoneNo);

}
