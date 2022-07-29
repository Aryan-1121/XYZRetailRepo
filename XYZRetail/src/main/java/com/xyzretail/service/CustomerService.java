package com.xyzretail.service;

import com.xyzretail.bean.Customer;

public interface CustomerService {
	boolean addCustomer(Customer customer);	//		To add new user/Customer
	
	boolean validateCustomer (Customer Customer);

}
