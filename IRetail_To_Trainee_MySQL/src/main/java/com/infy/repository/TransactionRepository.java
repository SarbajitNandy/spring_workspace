package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
}