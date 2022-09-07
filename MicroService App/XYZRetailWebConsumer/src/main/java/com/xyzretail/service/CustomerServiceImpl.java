package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
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
		
		ResponseEntity<Customer> cust=restTemplate.getForEntity("http://customer-service/customers", Customer.class);

		if(cust.getBody()!=null)
			return true;
		return false;
	}
	
	@Override
	public boolean validateCustomer(Customer customer) {
//	return customerDao.validateCustomer(customer);
		System.out.println(customer);
	
	ResponseEntity<Customer> cus=restTemplate.getForEntity("http://customer-service/customers/"+customer.getUserName()+"/"+customer.getUserPassword(), Customer.class); 
	if(cus.getStatusCode()!=HttpStatus.ACCEPTED) {
		return false;
	}
	System.out.println(cus);
	return true;
	
//	if(cus.getBody()!=null)
//		return true;
//	return false;
	
	}
}
