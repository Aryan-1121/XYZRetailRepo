package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements TransactionService {

	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean performTransaction(String customer) {
		Transaction tr=restTemplate.postForObject("http://transaction-service/transactions",customer, Transaction.class);
		if(tr!=null) {
			return true;
		}
		return false;
	}



	@Override
	public void insertIntoOrderTable(String customer) {
	
		
	}

}
