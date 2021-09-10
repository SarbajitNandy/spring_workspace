package com.infytel.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Customer;

@Repository("customerRepository")
public class CustomerDAOImpl implements CustomerDAO {
	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory (EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("Select c from Customer c");
		return (List<Customer>)query.getResultList();
	}

	@Override
	public void update(Long phoneNo, String address) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Customer cust =  entityManager.find(Customer.class, phoneNo);
		cust.setAddress(address);
		entityManager.getTransaction().commit();
	}

	

}
