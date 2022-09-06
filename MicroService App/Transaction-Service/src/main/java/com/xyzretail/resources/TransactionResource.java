package com.xyzretail.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Transaction;
import com.xyzretail.service.TransactionService;

@RestController
public class TransactionResource {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private TransactionService transactionService;
	
//	@Autowired
//	private ItemsCartDao itemsCartDao;
	

	@PostMapping(path = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean  PerformTransactionResource(@RequestBody  Transaction transaction) {
		return transactionService.saveTransaction(transaction);		
	}
	
	@GetMapping(path = "/transactions", produces =MediaType.APPLICATION_JSON_VALUE )
	public int getTransactionIdResource() {
		return transactionService.getMaxTransactionId();
	}
	
	
	@GetMapping(path = "/transactions/{userName}", produces =MediaType.APPLICATION_JSON_VALUE )
	public List<Transaction>getTransactionByuserName(@PathVariable("userName") String name) {
		return transactionService.getTransactionByName(name);
	}
	
	
	@GetMapping(path = "/transactions/all", produces =MediaType.APPLICATION_JSON_VALUE )
	public List<Transaction>getAllTransaction() {
		return transactionService.getAllTransaction();
	}
	
}
