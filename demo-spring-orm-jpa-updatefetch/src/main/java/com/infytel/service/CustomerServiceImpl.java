package com.infytel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerDAO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;

	@Override
	public List<CustomerDTO> getAll() {

		List<CustomerDTO> custList = new ArrayList<>();
		List <Customer> custEntityList = customerDAO.getAll();
		for (Customer customerEntity : custEntityList) {
			CustomerDTO custDTO = Customer.prepareDTO(customerEntity);
			custList.add(custDTO);
		}
		
		return custList;
	
	}

	@Override
	public void update(Long phoneNo, String address) {
		customerDAO.update(phoneNo, address);
		
	}
	
	
}
