package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dto.CustomerDTO;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerRepository;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException {
		CustomerDTO customerDTO = customerRepository.getCustomer(customerId);
		if (customerDTO == null) {
			throw new InfyBankException("Service.CUSTOMER_UNAVAILABLE");
		}
		return customerDTO;
	}
	@Override
	public void addCustomer(CustomerDTO customerDTO) throws InfyBankException {
		if (customerRepository.getCustomer(customerDTO.getCustomerId())!= null) throw new InfyBankException("Service.CUSTOMER_ALREADY_EXISTS");	
		customerRepository.addCustomer(customerDTO);
	}
	@Override
	public Integer removeCustomer(Integer customerId) throws InfyBankException {
		if (customerRepository.getCustomer(customerId)== null) throw new InfyBankException("Service.CUSTOMER_DOESN'T_EXIST");
		Integer customerIdreturned = customerRepository.removeCustomer(customerId);		
		return customerIdreturned;
	}
	@Override
	public Integer updateCustomerEmail(Integer customerId, String emailId) throws InfyBankException {
		if (customerRepository.getCustomer(customerId)==null) throw new InfyBankException("Service.CUSTOMER_DOESN'T_EXIST");
		Integer updateCustomerId = customerRepository.updateCustomerEmail(customerId, emailId);
		return updateCustomerId;
	}
}