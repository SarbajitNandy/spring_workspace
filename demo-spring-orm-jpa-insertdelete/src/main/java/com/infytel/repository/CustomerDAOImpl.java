package com.infytel.repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

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
	public void insert(Customer customer) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();

	}

	@Override
	public int remove(Long phoneNo) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		int result = 0;
		try {
			Customer emp = entityManager.find(Customer.class, phoneNo);
			entityManager.remove(emp);
			result = 1;
			entityManager.getTransaction().commit();
		} catch (Exception exp) {
			entityManager.getTransaction().rollback();
		}
		entityManager.close();
		return result;

	}

}
