package com.xyzretail.service;

import com.xyzretail.bean.Customer;
import com.xyzretail.persistence.CustomerDao;
import com.xyzretail.persistence.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();
	
	@Override
	public boolean addCustomer(Customer customer) {

		
		
		
		return customerDao.addCustomer(customer);
	}

	

	

	@Override
	public boolean validateCustomer(Customer customer) {

		
		
		return customerDao.validateCustomer(customer);
	}

	

}
