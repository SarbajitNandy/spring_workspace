package com.sarbajit;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		// Fetching entry
		Student s = em.find(Student.class, 2);
		
		System.out.println(s);
		
		// Creating new entry 
		Student sNew = new Student();
		sNew.setDept("IT");
		sNew.setId(4);
		sNew.setSname("Roshan");
		
		em.getTransaction().begin();
		
		em.persist(sNew);
		em.getTransaction().commit();
	}

}
