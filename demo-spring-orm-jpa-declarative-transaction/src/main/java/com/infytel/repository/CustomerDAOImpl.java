package com.infytel.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Customer;

@Repository("customerRepository")
public class CustomerDAOImpl implements CustomerDAO {
	//Spring ORM is used for inserting and updating the Employee record
	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory (EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public void insert(Customer customer) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();


	}	
		
	@Override
	public void update(Customer customer) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.merge(customer);
		
	}

	
}
