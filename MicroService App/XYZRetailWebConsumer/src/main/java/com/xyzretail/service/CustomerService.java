package com.xyzretail.service;

import com.xyzretail.bean.Customer;

public interface CustomerService {
	
	//boolean removeCustomer(  Customer  customer);
	boolean addCustomer(Customer customer);
	boolean validateCustomer(Customer customer);
	
}
