package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;


public interface ItemsService {

	
	
	boolean searchItemsById(String itemId,int reqQuantity);
	ItemDetails searchItemsById(String itemId);
	
	public void updateRecord(String itemID , int quantity);

	List<ItemDetails> getAllItems();

	double generateBill();

	double getTax(ItemDetails item);

	boolean validateCustomer();

	double setTax(ItemDetails item);


}
