package com.xyzretail.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Customers;
import com.xyzretail.model.service.CustomerService;
@RestController
public class CustomerResource {
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping(path="/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customers getAllCustomerResource() {
		return new Customers(customerService.getAllCustomer());
	}
	
	@GetMapping(path = "/customers/{user_Name}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByUserNameResource(@PathVariable("user_Name") String user_Name) {
		Customer customer = customerService.customerByName(user_Name);
		if(customer != null) {
			return new ResponseEntity<Customer>(customer , HttpStatus.FOUND);
		}
		
		return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping(path = "/customers/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer>  registerCustomerResource(@RequestBody  Customer customer) {
		Customer cus = customerService.customerByName(customer.getUser_Name());
		boolean isRegistered=false;
		if(cus==null)
			 isRegistered= customerService.registerCustomer(customer);
		if(isRegistered) {
			return new ResponseEntity<Customer>(customer , HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_ACCEPTABLE);
	
	}
	
	@GetMapping(path = "customers/{user_Name}/{user_Password}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> loginCustomerResource(@PathVariable("user_Name") String user_Name,@PathVariable("user_Password") String user_Password) {
		Customer customer= customerService.loginCustomer(user_Name, user_Password);
		if (customer != null)
			
			return new ResponseEntity<Customer>(customer , HttpStatus.ACCEPTED);
		return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	
	
}










