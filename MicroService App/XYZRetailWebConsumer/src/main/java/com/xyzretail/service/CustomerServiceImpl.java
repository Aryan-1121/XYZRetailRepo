package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

//	private CustomerDao customerDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	public void setCustomerDao(CustomerDao customerDao) {
//		this.customerDao = customerDao;
//	}

	@Override
	public boolean addCustomer(Customer customer) {
		
		ResponseEntity<Customer> cust=restTemplate.postForEntity("http://customer-service/customers",customer, Customer.class);
		//ResponseEntity<Customer> cust=restTemplate.exchange("http://customer-service/customers",HttpMethod.POST,customer, Customer.class);
		if(cust.getBody()!=null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateCustomer(Customer customer) {
//	return customerDao.validateCustomer(customer);
	
	ResponseEntity<Customer> cus=restTemplate.getForEntity("http://customer-service/"+customer.getUserName()+"/"+customer.getUserPassword(), Customer.class); 
	if(cus.getStatusCode()!=HttpStatus.ACCEPTED) {
		return false;
	}
	return true;
	}
}
