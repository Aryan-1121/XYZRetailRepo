package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.Transaction;
import com.xyzretail.persistence.TransactionDao;

@Service
public class TransactionerviceImpl implements TransactionService{
	@Autowired
	private TransactionDao transactionDao;
		

	@Override
	public int saveTransaction(Transaction transaction) {
			transactionDao.save(transaction);
		return 1;
	}


	@Override
	public int saveTransactionByUserName(String userName) {
			transactionDao.saveTransactionByUserName(userName);
//			transactionDao.
		return 1;
	}
	@Override
	public int getMaxTransactionId() {

		return transactionDao.getMaxTransactionId();
	}


	@Override
	public List<Transaction> getAllTransaction() {
		return transactionDao.findAll();
				}


	@Override
	public List<Transaction> getTransactionByName(String userName) {
		
		return transactionDao.getTransactionByUserName(userName);
	}

}
