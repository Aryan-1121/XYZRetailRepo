package com.xyzretail.service;

import com.xyzretail.bean.Customer;

public interface CustomerService {

	
	
	boolean addCustomer(  Customer customer);
	//boolean removeCustomer(  Customer  customer);
	boolean validateCustomer(Customer customer);
	
}
