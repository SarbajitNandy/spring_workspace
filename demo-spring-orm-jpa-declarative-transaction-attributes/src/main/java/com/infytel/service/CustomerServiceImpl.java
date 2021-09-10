package com.infytel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.dto.CustomerDTO;
import com.infytel.entity.Customer;
import com.infytel.repository.CustomerDAO;
import com.infytel.repository.PlanDAO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	PlanDAO planDAO;
	
	@Override
	@Transactional(timeout = 40)
	public void insert(CustomerDTO customerDTO) {
		customerDAO.insert(CustomerDTO.prepareCustomerEntity(customerDTO));
	}

	@Override
	@Transactional(noRollbackFor = RuntimeException.class)
	//Update on Customer and Plan table are executed in transaction scope
	public void update(CustomerDTO customerDTO) {
		//Method to update the current plan in Customer table
		customerDAO.update(CustomerDTO.prepareCustomerEntity(customerDTO));
		
		//Method to update the new plan details in Plan table
		planDAO.updatePlan(CustomerDTO.prepareCustomerEntity(customerDTO).getPlan());
	}

	@Override
	@Transactional(readOnly=true)
	public CustomerDTO getCustomer(Long phoneNo) {

		return  Customer.prepareCustomerDTO(customerDAO.getCustomer(phoneNo));
	}

	

}
