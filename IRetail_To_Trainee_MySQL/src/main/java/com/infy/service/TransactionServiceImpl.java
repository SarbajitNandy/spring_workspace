package com.infy.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.TransactionDTO;
import com.infy.entity.Transaction;
import com.infy.exception.IRetailException;
import com.infy.repository.TransactionRepository;
import com.infy.validator.Validator;

@Service(value = "transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	/**
	 This method first calls validate method of Validator passing TransactionDTO object received in parameter,
	 then calls save method of transactionRepository by passing Transaction entity object.
	 @param Transaction object
	 @return transactionId returned after calling save method of transactionRepository
	 */
	public Integer makeTransaction(TransactionDTO transactionDTO) throws IRetailException {
		Validator validator = new Validator();
		try {
			validator.validate(transactionDTO);
			Transaction transaction = new Transaction();
			transaction.setAmount(transactionDTO.getAmount());
			transaction.setCustomerId(transactionDTO.getCustomerId());
			transaction.setTransactionDateTime(transactionDTO.getTransactionDateTime());
//			transaction.setTransactionId(transactionDTO.getTransactionId());
			Transaction insertedTransaction= transactionRepository.save(transaction);
			return insertedTransaction.getTransactionId();
		} catch(IRetailException e) {
			throw e;
		}
	}

	/**
	 This method  calls  findById method of transactionRepository passing transactionId  received in parameter
	 @param Integer transactionId
	 @return TransactionDTO object populated by Transaction Entity object returned from findById method of transactionRepository
	 @throws Service.INVALID_TRANSACTION_ID exception if object returned from findById method of transactionRepository is null
	 */
	public TransactionDTO getTransactionDetails(Integer transactionId) throws IRetailException {
		Optional<Transaction> option = transactionRepository.findById(transactionId);
		if (!option.isPresent()) throw new IRetailException("Service.INVALID_TRANSACTION_ID");
		Transaction transaction = option.orElseThrow(()-> new IRetailException("Service.INVALID_TRANSACTION_ID"));
		TransactionDTO transactionDTO = new TransactionDTO();
		transactionDTO.setAmount(transaction.getAmount());
		transactionDTO.setCustomerId(transaction.getCustomerId());
		transactionDTO.setTransactionDateTime(transaction.getTransactionDateTime());
		transactionDTO.setTransactionId(transaction.getTransactionId());
		return transactionDTO;
	}



}
