package com.infytel.repository;

import java.util.List;

import com.infytel.domain.Customer;


public interface ICustomerRepository {

	public List<Customer> searchCustomer(String name, String addr, Character gender, Integer age);
}
