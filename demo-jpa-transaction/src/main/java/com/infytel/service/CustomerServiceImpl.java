package com.infytel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infytel.dto.CustomerDTO;
import com.infytel.dto.PlanDTO;
import com.infytel.repository.CustomerRepository;
import com.infytel.repository.PlanRepository;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PlanRepository planRepository;
	
	@Override
	public void insert(CustomerDTO customerDTO) {
		customerRepository.saveAndFlush(CustomerDTO.prepareEntity(customerDTO));
	}

	@Override

	//Update on Customer and Plan table are executed in transaction scope
	public void updateCustomer(CustomerDTO customerDTO) {
		//Method to update the current plan in Customer table
		customerRepository.customerUpdate(PlanDTO.preparePlanEntity(customerDTO.getPlan()),customerDTO.getPhoneNumber());
		
		//Method to update the new plan details in Plan table
		planRepository.updatePlan(CustomerDTO.prepareEntity(customerDTO).getPlan().getLocalRate(),CustomerDTO.prepareEntity(customerDTO).getPlan().getNationalRate(),CustomerDTO.prepareEntity(customerDTO).getPlan().getPlanId());
	}

	

}
