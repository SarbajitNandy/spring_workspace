package com.infy.service;

import java.time.LocalDate;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;

public interface CustomerService {
	public void addCustomer(CustomerDTO customer) throws InfyBankException;
	public String findEmailById(Integer customer_id) throws InfyBankException;
	public LocalDate findDOBBYId(Integer customerId) throws InfyBankException;
	public CustomerDTO findByEmailId(String emailId) throws InfyBankException;
}
