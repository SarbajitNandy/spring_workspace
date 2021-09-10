package com.infytel.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Customer;

@Repository("customerRepository")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();

	}

	@Override
	public int remove(Long phoneNo) {
		 Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int result = 0;
		try {
			Customer emp = session.get(Customer.class, phoneNo);
			session.delete(emp);
			result = 1;
			tx.commit();
		} catch (Exception exp) {
			tx.rollback();
		}
		session.close();
		return result;

	}

}
