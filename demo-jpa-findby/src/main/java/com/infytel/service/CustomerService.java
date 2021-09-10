package com.infytel.service;


import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;

	public Iterable<Customer> getCustomer(String address);

}