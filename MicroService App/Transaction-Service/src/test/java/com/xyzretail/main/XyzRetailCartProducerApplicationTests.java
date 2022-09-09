package com.xyzretail.main;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
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

import com.xyzretail.bean.Transaction;
import com.xyzretail.persistence.TransactionDao;
import com.xyzretail.service.TransactionerviceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class XyzRetailCartProducerApplicationTests {
	
	@InjectMocks
	@Autowired
	private TransactionerviceImpl transactionerviceImpl;
	
	
	@Mock
	private TransactionDao transactionDao;
	
	private List<Transaction> transaction=new ArrayList<>();
	
	private AutoCloseable closeable;
	
	Date date;

	
//	private int transactionId;
//	private String userName;
//	private Date date;
//	private Time time;
	
	@BeforeEach
	void setUp() throws Exception{
		transaction.add(new Transaction(1,"User001",new Date(2022, 11, 16),new Time(18,35,37)));
		
		closeable=MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	void R001_T001() {
		Mockito.when(transactionDao.save(new Transaction(1,"User001",new Date(2022, 11, 16),new Time(18,35,37)))).thenReturn(transaction.get(0));
		assertTrue(transactionerviceImpl.saveTransaction(transaction.get(0)));
	
	}

}
