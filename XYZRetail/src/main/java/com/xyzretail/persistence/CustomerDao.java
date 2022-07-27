package com.xyzretail.persistence;

import com.xyzretail.bean.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer customer);	//		To add new user/Customer
	
	boolean validateCustomer (Customer Customer);
	
	
}
