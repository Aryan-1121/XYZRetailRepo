package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Customers;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override

	public boolean addCustomer(Customer customer) {
		try {

		Customers cus= restTemplate.getForObject("http://customer-service/customers/", Customers.class);
		if(!cus.getCustomers().contains(customer)) {
			ResponseEntity<Customer> cust= restTemplate.postForEntity("http://customer-service/customers/", customer,Customer.class);	
			return true;
		}
		return false;
//			
		}
		catch(Exception ex){
			return false ;
		}

		
//		restTemplate.postForObject("http://customer-service/customers/"+customer.getUserName()+"/"+customer.getUserPassword(),  customer.getUserName(),customer.getUserPassword(),Boolean.class);
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
