package com.infy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infy.dto.CustomerDTO;
import com.infy.entity.Customer;
import com.infy.exception.InfyBankException;

@Repository(value = "customerRepository")
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
	@PersistenceContext
	private EntityManager entityManager;
    
    public CustomerDTO getCustomer(Integer customerId) {
		CustomerDTO customerDTO=null;	
		Customer customer = entityManager.find(Customer.class, customerId);
		if(customer!=null){
			customerDTO=new CustomerDTO();
			customerDTO.setCustomerId(customer.getCustomerId());
			customerDTO.setDateOfBirth(customer.getDateOfBirth());
			customerDTO.setEmailId(customer.getEmailId());
			customerDTO.setName(customer.getName());
			customerDTO.setCustomerType(customer.getCustomerType());
		}
		return customerDTO;
	}

	@Override
	public void addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setCustomerType(customerDTO.getCustomerType());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setName(customerDTO.getName());
//		Transaction transaction = (Transaction) entityManager.getTransaction();
		entityManager.persist(customer);
	}

	@Override
	public Integer removeCustomer(Integer customerId) {
		Customer customer = null;
		customer = entityManager.find(Customer.class, customerId);
		entityManager.remove(customer);
		return customer.getCustomerId();
	}
	
	@Override
	public Integer updateCustomerEmail(Integer customerId, String emailId) {
		Customer customer = null;
		customer = entityManager.find(Customer.class, customerId);
		customer.setEmailId(emailId);
		return customer.getCustomerId();
	}
}