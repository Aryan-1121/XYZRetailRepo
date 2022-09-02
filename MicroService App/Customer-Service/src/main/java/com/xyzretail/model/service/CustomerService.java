package com.xyzretail.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzretail.bean.Customer;
@Service
public interface CustomerService {
	Customer customerByName(String user_Name);
	List<Customer> getAllCustomer();
	boolean registerCustomer(Customer customer);
	Customer loginCustomer(String user_Name, String user_Password);


}
