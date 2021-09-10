package com.infytel.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	  @Autowired
	  private CustomerRepository  repository; 
	  
	public void insertCustomer(CustomerDTO customer) {
		repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));
	
	}

	@Override
	public Customer getCustomer(String address) {
		
		return repository.findByAddress(address);
	}
	
	
}
