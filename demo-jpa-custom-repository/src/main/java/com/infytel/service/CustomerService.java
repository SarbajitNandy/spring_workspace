package com.infytel.service;


import java.util.List;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;

	public List<Customer> searchCustomer(String name, String address, Character gender, Integer age) ;

}