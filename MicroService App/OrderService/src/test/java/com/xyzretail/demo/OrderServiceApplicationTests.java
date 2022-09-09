package com.xyzretail.demo;

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

import com.xyzretail.bean.Orders;
import com.xyzretail.persistence.OrderDao;
import com.xyzretail.service.OrderServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OrderServiceApplicationTests {

	@InjectMocks
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@Mock
	private OrderDao orderDao;
	
	private List<Orders> order=new ArrayList<>();
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void setUp() throws Exception{
		order.add(new Orders(1,100,"B-101",6));
		order.add(new Orders(2,101,"C-101",10));
		order.add(new Orders(3,102,"CS-101",2));
		
		closeable=MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}
	
	@DisplayName("Saving Order")
	@Test
	void R001_T001() {
		Mockito.when(orderDao.save(new Orders(1,100,"B-101",6))).thenReturn(order.get(0));
		Mockito.when(orderDao.save(new Orders(2,101,"C-101",10))).thenReturn(order.get(1));
		Mockito.when(orderDao.save(new Orders(3,102,"CS-101",2))).thenReturn(order.get(2));
	
		assertEquals(order.get(0), orderServiceImpl.saveOrder(new Orders(1,100,"B-101",6)));
	}
	
	

}
