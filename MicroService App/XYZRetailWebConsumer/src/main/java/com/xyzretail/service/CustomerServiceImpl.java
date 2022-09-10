package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override

	public boolean addCustomer(Customer customer) {
		ResponseEntity<Customer> cust=restTemplate.postForEntity("http://customer-service/customers/",customer, Customer.class);
//		if(cust.getBody()!=null)
//			return true;
//		return false;
		if(cust.getBody().getUserName()!=null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateCustomer(Customer customer) {
	ResponseEntity<Customer> cus=restTemplate.getForEntity("http://customer-service/customers/"+customer.getUserName()+"/"+customer.getUserPassword(), Customer.class); 
	if(cus.getStatusCode()!=HttpStatus.ACCEPTED) {
		return false;
	}
	return true;

	}
}
