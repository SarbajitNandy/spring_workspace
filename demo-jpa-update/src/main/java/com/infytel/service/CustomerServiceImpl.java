package com.infytel.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;

	public void insertCustomer(CustomerDTO customer) {
		repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));
	}

	@Override
	public void insert() {

		repository.insert();
	}

	@Override
	public void addressUpdate(String address, Long phoneNumber) {
		repository.addressUpdate(address, phoneNumber);
	}

}
