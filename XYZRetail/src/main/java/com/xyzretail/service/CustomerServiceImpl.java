package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.Customer;
import com.xyzretail.persistence.CustomerDao;
import com.xyzretail.persistence.CustomerDaoImpl;

@Service("cutomerService")
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}



	@Override
	public int addCustomer(Customer customer) {

		
		return customerDao.addCustomer(customer);
	}

	

	

	@Override
	public boolean validateCustomer(Customer customer) {
		
		if(customerDao.validateCustomer(customer)!=null) {
			return true;
		}
		return false;
	}

	

}
