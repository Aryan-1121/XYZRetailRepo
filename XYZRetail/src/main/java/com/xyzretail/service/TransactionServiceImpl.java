package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.TransactionDao;
import com.xyzretail.persistence.TransactionDaoImpl;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDao transactionDao = new TransactionDaoImpl();
	
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
