package com.infytel.service;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;

	public void insert();

	public void addressUpdate(String address, Long phoneNumber);

}