package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.TransactionDao;
@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	private TransactionDao transactionDao;
	
	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public boolean performTransaction(String customer) {

		return transactionDao.performTransaction(customer);
	}

	@Override
	public boolean performTransaction(List<ItemsCart> itemsCart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertIntoOrderTable(String customer) {
		transactionDao.insertIntoOrderTable(customer);
		
	}

}
