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

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.persistence.ItemDetailDao;
import com.xyzretail.service.ItemDetailServiceImpl;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ItemDetailsCartServiceTests {
	
	@InjectMocks
	@Autowired
	private ItemDetailServiceImpl itemDetailServiceImpl;
	
	@Mock
	private ItemDetailDao itemDetailDao;
	
	private List<ItemDetail> item=new ArrayList<>();
	
	private AutoCloseable closeable;
	
	@BeforeEach
	void setUp() throws Exception{
		item.add(new ItemDetail("B-101","Books","Harry Porter",400,50));
		item.add(new ItemDetail("C-101","CD","Bollywood Songs",100,5));
		item.add(new ItemDetail("CS-101","Cosmetics","Lipstick",250,15));
		
		closeable=MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		closeable.close();
	}

	@Test
	void R001_T001() {
		Mockito.when(itemDetailDao.findAll()).thenReturn(item);
		assertEquals(item, itemDetailServiceImpl.getAllItemDetails());
	}
	
	@Test
	void R001_T002() {
		Mockito.when(itemDetailDao.findAll()).thenReturn(null);
		assertEquals(null, itemDetailServiceImpl.getAllItemDetails());
	}
	
	@Test
	void R002_T001() {
		Mockito.when(itemDetailDao.findById("B-101")).thenReturn(Optional.of(item.get(0)));
		Mockito.when(itemDetailDao.findById("C-101")).thenReturn(Optional.of(item.get(1)));
		Mockito.when(itemDetailDao.findById("CS-101")).thenReturn(Optional.of(item.get(2)));
		
		assertEquals(item.get(0), itemDetailServiceImpl.findByItemId("B-101"));
	}
	
	@Test
	void R002_T002() {
		Mockito.when(itemDetailDao.findById(null)).thenThrow(new NullPointerException());
	}
	
	@Test
	void R003_T001() {
		Mockito.when(itemDetailDao.findByItemIdAndAvailableQuantity("B-101",40)).thenReturn(item.get(0));
		Mockito.when(itemDetailDao.findByItemIdAndAvailableQuantity("C-101",5)).thenReturn(item.get(1));
		Mockito.when(itemDetailDao.findByItemIdAndAvailableQuantity("CS-101",10)).thenReturn(item.get(2));
		assertEquals(item.get(0), itemDetailServiceImpl.findByItemId_AndAvailable_Quantity("B-101",40));
	}
	
	@Test
	void R003_T002() {
		Mockito.when(itemDetailDao.findByItemIdAndAvailableQuantity(null,0)).thenThrow(new NullPointerException());
	}
	
	@Test
	void R004_T001() {
		Mockito.when(itemDetailDao.updateRecord(100,"B-101")).thenReturn(1);
		Mockito.when(itemDetailDao.updateRecord(10,"C-101")).thenReturn(1);
		Mockito.when(itemDetailDao.updateRecord(30,"CS-101")).thenReturn(1);
		assertEquals(1, itemDetailServiceImpl.updateRecord("B-101",100));
	}

	@Test
	void R004_T002() {
		Mockito.when(itemDetailDao.updateRecord(0,null)).thenReturn(0);
		assertEquals(0, itemDetailServiceImpl.updateRecord(null,0));
	}
}
