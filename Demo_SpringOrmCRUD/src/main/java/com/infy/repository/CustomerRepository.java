package com.infy.repository;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;

public interface CustomerRepository{
	public CustomerDTO getCustomer(Integer customerId);
	public void addCustomer(CustomerDTO customerDTO);
	public Integer removeCustomer(Integer customerId) ;
	public Integer updateCustomerEmail(Integer customerId, String emailId) ;
}