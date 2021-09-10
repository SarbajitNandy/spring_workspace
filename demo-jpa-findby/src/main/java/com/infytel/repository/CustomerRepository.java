package com.infytel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infytel.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByAddress(String address);
}
