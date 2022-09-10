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
		transaction.add(new Transaction(2,"User002",new Date(2021, 10, 26),new Time(12,05,37)));
		transaction.add(new Transaction(3,"User003",new Date(2020, 01, 06),new Time(12,15,37)));
		closeable=MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@DisplayName("Save Transaction")
	@Test
	void R001_T001() {
		Mockito.when(transactionDao.save(new Transaction(1,"User001",new Date(2022, 11, 16),new Time(18,35,37)))).thenReturn(transaction.get(0));
		Mockito.when(transactionDao.save(new Transaction(2,"User002",new Date(2021, 10, 26),new Time(12,05,37)))).thenReturn(transaction.get(1));
		Mockito.when(transactionDao.save(new Transaction(3,"User003",new Date(2020, 01, 06),new Time(12,15,37)))).thenReturn(transaction.get(2));
		
		assertTrue(transactionerviceImpl.saveTransaction(transaction.get(0)));
	
	}

	@DisplayName("Save Transaction By Existed UserName")
	@Test
	void R002_T001() {
		Mockito.when(transactionDao.saveTransactionByUserName("User001")).thenReturn(0);
		Mockito.when(transactionDao.saveTransactionByUserName("User002")).thenReturn(0);
		Mockito.when(transactionDao.saveTransactionByUserName("User003")).thenReturn(0);
		assertFalse(transactionerviceImpl.saveTransactionByUserName("User001"));
	
	}
	
	@DisplayName("Save Transaction By Non-Existed UserName")
	@Test
	void R002_T002() {
		Mockito.when(transactionDao.saveTransactionByUserName(null)).thenReturn(0);
		assertFalse(transactionerviceImpl.saveTransactionByUserName(null));
	
	}
	
	@DisplayName("Get Maximum Transaction By Id")
	@Test
	void R003_T001() {
		Mockito.when(transactionDao.getMaxTransactionId()).thenReturn(1);
		assertEquals(1, transactionerviceImpl.getMaxTransactionId());
	
	}
	
	@DisplayName("Get All Transaction By Existed User")
	@Test
	void R004_T001() {
		Mockito.when(transactionDao.findAll()).thenReturn(transaction);
		assertEquals(transaction,transactionerviceImpl.getAllTransaction());
	
	}
	
	@DisplayName("Get All Transaction By Non-Existed User")
	@Test
	void R004_T002() {
		Mockito.when(transactionDao.findAll()).thenReturn(null);
		assertEquals(null, transactionerviceImpl.getAllTransaction());
	
	}
	
	@DisplayName("Get All Transaction By Existed UserName")
	@Test
	void R005_T001() {
		Mockito.when(transactionDao.getTransactionByUserName("User001")).thenReturn(transaction);
		Mockito.when(transactionDao.getTransactionByUserName("User002")).thenReturn(transaction);
		Mockito.when(transactionDao.getTransactionByUserName("User003")).thenReturn(transaction);
		assertEquals(transaction, transactionerviceImpl.getTransactionByName("User001"));
	
	}
	
@DisplayName("Get All Transaction By Non-Existed UserName")
@Test
void R005_T002() {
	Mockito.when(transactionDao.getTransactionByUserName(null)).thenReturn(null);
	assertEquals(null, transactionerviceImpl.getTransactionByName(null));

}
}
