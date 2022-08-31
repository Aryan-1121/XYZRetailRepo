package com.xyzretail.service;

import com.xyzretail.bean.Transaction;

public interface TransactionService {
	
	Transaction performTransaction(String customer);
	
}
