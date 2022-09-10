package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		boolean tr=restTemplate.postForObject("http://transaction-service/transaction/",userName, Boolean.class);
		
		return tr;
	}



	@Override
	public void insertIntoOrderTable(String customer) {
		
		
	}

}
