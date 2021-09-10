package com.infytel.service;

import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerDAO;
import com.infytel.repository.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerDAO = new CustomerDAOImpl();

	@Override
	public void insert(CustomerDTO customer) {
		customerDAO.insert(CustomerDTO.prepareCustomerEntity(customer));
	}

	@Override
	public int remove(Long phoneNo) {
		int result = customerDAO.remove(phoneNo);
		return result;
	}
}
