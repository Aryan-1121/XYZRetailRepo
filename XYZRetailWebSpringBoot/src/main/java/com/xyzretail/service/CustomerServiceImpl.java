package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.Customer;
import com.xyzretail.persistence.CustomerDao;
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public boolean addCustomer(Customer customer) {

		return customerDao.addCustomer(customer);
	}
	@Override
	public boolean validateCustomer(Customer customer) {
//	return customerDao.validateCustomer(customer);
	
	Customer cus= customerDao.validateCustomer(customer);
	if(cus==null)	 
		return false;
	
	
	else if (cus.getUserName().equals(customer.getUserName())) {	
		if(cus.getUserPassword().equals(customer.getUserPassword())) 
			return true;
		return false ;
	}
	return false;
	}
	}
