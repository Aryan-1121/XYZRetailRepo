package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Transaction;

public interface TransactionService {
	boolean saveTransaction(Transaction transaction);
	int getMaxTransactionId();
	List<Transaction> getAllTransaction();
	List<Transaction> getTransactionByName(String userName);
	
}
