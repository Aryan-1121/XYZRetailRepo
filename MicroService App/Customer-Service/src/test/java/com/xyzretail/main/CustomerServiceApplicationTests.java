package com.xyzretail.main;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.xyzretail.bean.Customer;
import com.xyzretail.model.persistence.CustomerDao;
import com.xyzretail.model.service.CustomerServiceImpl;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CustomerServiceApplicationTests {
	
	@InjectMocks
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	
	@Mock
	private CustomerDao customerDao;
	
	private List<Customer> customer=new ArrayList<>();
	
	private AutoCloseable closeable;
	
	
	@BeforeEach
	void setUp() throws Exception{
		customer.add(new Customer("User001","Password001"));
		customer.add(new Customer("User002","Password002"));
		customer.add(new Customer("User003","Password003"));
		
		closeable=MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@DisplayName("Get Existed Customer List")
	@Test
	void R001_T001() {
		Mockito.when(customerDao.findAll()).thenReturn(customer);
		assertIterableEquals(customer, customerServiceImpl.getAllCustomer());
	}
	
	@DisplayName("Get Non-Existed Customer")
	@Test
	void R001_T002() {
		Mockito.when(customerDao.findAll()).thenReturn(null);
		assertEquals(null, customerServiceImpl.getAllCustomer());
	}
	
//	@DisplayName("Register Existed Customer")
//	@Test
//	void R002_T001() {
//		Mockito.when(customerDao.registerCustomer("User001", "Password001")).thenReturn(0);
//		Mockito.when(customerDao.registerCustomer("User002", "Password002")).thenReturn(1);
//		Mockito.when(customerDao.registerCustomer("User003", "Password003")).thenReturn(2);
//		assertTrue(customerServiceImpl.registerCustomer(new Customer("User001", "Password001")));
//		
//	}
	
	@DisplayName("Register Existed Customer")
	@Test
	void R002_T001() {
		Mockito.when(customerDao.save(new Customer("User001", "Password001"))).thenReturn(customer.get(0));
		Mockito.when(customerDao.save(new Customer("User002", "Password002"))).thenReturn(customer.get(1));
		Mockito.when(customerDao.save(new Customer("User003", "Password003"))).thenReturn(customer.get(2));
		assertTrue(customerServiceImpl.registerCustomer(new Customer("User001", "Password001")));
		
	}

	@DisplayName("Register Non-Existed Customer")
	@Test
	void R002_T002() {
		Mockito.when(customerDao.save(new Customer("User004", "Password004"))).thenReturn(customer.get(0));
		assertTrue(customerServiceImpl.registerCustomer(new Customer("User004","Password004")));
		
	}
	
	@DisplayName("Login Valid Customer")
	@Test
	void R003_T001() {
		Mockito.when(customerDao.findById("User001")).thenReturn(Optional.of(customer.get(0)));
		Mockito.when(customerDao.findById("User002")).thenReturn(Optional.of(customer.get(1)));
		Mockito.when(customerDao.findById("User003")).thenReturn(Optional.of(customer.get(2)));
		assertEquals(customer.get(0), customerServiceImpl.loginCustomer("User001","Password001"));
	}
	
	@DisplayName("Login Invalid Customer")
	@Test
	void R003_T002() {
		Mockito.when(customerDao.findById("User001")).thenReturn(Optional.of(customer.get(0)));
		Mockito.when(customerDao.findById("User002")).thenReturn(Optional.of(customer.get(1)));
		Mockito.when(customerDao.findById("User003")).thenReturn(Optional.of(customer.get(2)));
		assertNotEquals(customer.get(0), customerServiceImpl.loginCustomer("User001","Password002"));
	}
	
	@DisplayName("Login Unregistered Customer")
	@Test
	void R003_T003(){
		Mockito.when(customerDao.findById("User004")).thenReturn(Optional.of(customer.get(0)));
		assertNotEquals(customer.get(0), customerServiceImpl.loginCustomer("User004","Password004"));
	}
	
	@DisplayName("Get Existed Customer By Name")
	@Test
	void R004_T001() {
		Mockito.when(customerDao.findById("User001")).thenReturn(Optional.of(customer.get(0)));
		assertEquals(customer.get(0),customerServiceImpl.customerByName("User001"));
	}
	
	@DisplayName("Get Non-Existed Customer By Name")
	@Test
	void R004_T002() {
		Mockito.when(customerDao.findById("User004")).thenReturn(Optional.of(customer.get(0)));
		assertNotEquals(null,customerServiceImpl.customerByName("User004"));
	}
	
	@DisplayName("Get Null Customer By Name")
	@Test
	void R004_T003() {
		Mockito.when(customerDao.findById(null)).thenThrow(new NullPointerException());
	}
}
