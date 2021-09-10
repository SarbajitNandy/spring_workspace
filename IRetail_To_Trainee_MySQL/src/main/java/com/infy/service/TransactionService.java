package com.infy.service;

import com.infy.dto.TransactionDTO;
import com.infy.exception.IRetailException;

public interface TransactionService {
	public Integer makeTransaction(TransactionDTO transactionDTO) throws IRetailException;

	public TransactionDTO getTransactionDetails(Integer transactionId) throws IRetailException;
	
}
