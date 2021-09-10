package com.infytel.service;


import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	// Method to access data access layer method to insert Customer record
	public void insertCustomer(CustomerDTO customer) ;

		// Method to access data access layer method to remove a record
		public void removeCustomer(long phoneNo);
}