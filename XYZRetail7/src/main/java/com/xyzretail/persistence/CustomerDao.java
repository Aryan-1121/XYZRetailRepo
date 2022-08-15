package com.xyzretail.persistence;

import com.xyzretail.bean.Customer;

public interface CustomerDao {		// Completed 

	boolean addCustomer(Customer customer);	//		To Register new Customer 
	
	Customer validateCustomer (Customer Customer);		//		Login verification 
	
	
}
