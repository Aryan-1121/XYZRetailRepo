package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private RestTemplate restTemplate;

//	@Override
//	public boolean performTransaction(String customer) {
//		URI tr=restTemplate.postForLocation("http://transaction-service/transactions/"+customer, Transaction.class);
////		if(tr!=null) {
////			return true;
////		}
////		return false;
//
//	return true;
//	}

	
	@Override
	public boolean performTransaction(String userName) {
		restTemplate.postForObject("http://transaction-service/transaction/"+userName, userName,Transaction.class); 
//		restTemplate.post
		return true;
		
	}
//	@Override
//	public boolean performTransaction(String customer) {
//		restTemplate.postForObject("http://transaction-service/transactions",customer, Boolean.class);
//		return true;
//	}



	@Override
	public void insertIntoOrderTable(String customer) {
		
		
		
	}

}
