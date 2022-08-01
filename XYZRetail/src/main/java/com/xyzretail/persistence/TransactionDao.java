package com.xyzretail.persistence;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Transaction;

public interface TransactionDao {

		Transaction getTransactionDetails(Customer customerName);		// admin part !!
		
		boolean performTransaction(String customer);
		
		public void insertIntoOrderTable(String customer);
		
		public boolean updateTransaction(Customer customerName,String itemId);
	
}
