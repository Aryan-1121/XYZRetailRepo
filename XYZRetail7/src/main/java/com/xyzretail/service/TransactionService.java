package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemsCart;

public interface TransactionService {

	 boolean performTransaction(String customer);

	 public void insertIntoOrderTable(String customer);
	 
	boolean performTransaction(List<ItemsCart> itemsCart);
	
}
