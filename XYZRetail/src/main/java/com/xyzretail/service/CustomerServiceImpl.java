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
		Customer cus= customerDao.validateCustomer(customer);
		if(cus.getUserName().equals(null))	 {
			System.out.println("incorrect username");
			return false;
		}
		
		if(cus.getUserName().equals(customer.getUserName())) {
			
			if(cus.getUserPassword().equals(customer.getUserPassword())) 
				return true;
			
			else
				System.out.println("Check your Password and Try again :) ");
			}
		
		else {
				
			System.out.println("Check your User Name and Try again :) ");
			return false;
		}
		return false ;
	}

}
