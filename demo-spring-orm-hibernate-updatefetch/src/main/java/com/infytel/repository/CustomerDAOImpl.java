package com.infytel.repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infytel.entity.Customer;
import org.hibernate.query.Query;

@Repository("customerRepository")
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		Session session = sessionFactory.openSession();

		List<Customer> custList=null;
		try{
			Query<Customer> query = session.createQuery("from Customer"); 
			custList= query.list(); 
		}finally {
			session.close();
		}
		return custList;
	}

	@Override
	public void update(Long phoneNo, String address) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Customer cust =  session.get(Customer.class, phoneNo);
		cust.setAddress(address);
		session.update(cust);
		tx.commit();
		session.close();
	}

	

}
