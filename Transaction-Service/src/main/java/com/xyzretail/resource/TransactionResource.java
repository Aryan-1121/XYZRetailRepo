package com.xyzretail.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzretail.bean.Transaction;
import com.xyzretail.service.TransactionService;

@RestController
public class TransactionResource {

	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping(path="/transactions",produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Transaction saveTransactionResource(@RequestBody String customer) {
		return transactionService.performTransaction(customer);
	}
	
}
