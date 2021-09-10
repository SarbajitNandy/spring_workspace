package com.infy.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRespository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRespository customerRespository;

	@Override
	public void addCustomer(CustomerDTO customerDto) throws InfyBankException {
		Optional<Customer> optional = customerRespository.findById(customerDto.getCustomerId());
		if (optional.isPresent())
			throw new InfyBankException("Service.CUSTOMER_FOUND");
		Customer customer = new Customer();
		customer.setDateOfBirth(customerDto.getDateOfBirth());
		customer.setEmailId(customerDto.getEmailId());
		customer.setName(customerDto.getName());
		customer.setCustomerId(customerDto.getCustomerId());
		customerRespository.save(customer);
	}

	@Override
	public String findEmailById(Integer customer_id) throws InfyBankException {
		String emailId_returned = null;
		
		Optional<Customer> optional = customerRespository.findById(customer_id);
		if (optional.isPresent()) {
			emailId_returned = customerRespository.findEmailById(customer_id);
			return emailId_returned;
		} else throw new InfyBankException("Service.CUSTOMER_NOT_FOUND");
		
	}

	@Override
	public LocalDate findDOBBYId(Integer customerId) throws InfyBankException {
		LocalDate dob = null;
		
		Optional<Customer> optional = customerRespository.findById(customerId);
		if (optional.isPresent()) {
			dob = customerRespository.findDOBById(customerId);
			return dob;
		} else throw new InfyBankException("Service.CUSTOMER_NOT_FOUND");
	}

	@Override
	public CustomerDTO findByEmailId(String emailId) throws InfyBankException {
		Customer customer = null;
		
		Optional<Customer> optional = customerRespository.findByEmailId(emailId);
		if (optional.isPresent()) {
			customer = optional.orElseThrow(()-> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		}
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		
		return customerDTO ;

	}
	
	

}
