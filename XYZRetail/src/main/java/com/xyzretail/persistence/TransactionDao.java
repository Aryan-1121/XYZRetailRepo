package com.xyzretail.persistence;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Transaction;

public interface TransactionDao {

		Transaction getTransactionDetails(Customer customerName);
		
		public boolean updateTransaction(Customer customerName,String itemId);
	
}
