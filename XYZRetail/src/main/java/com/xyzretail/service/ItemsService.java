package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;


public interface ItemsService {

	List<ItemDetails> getAllItems();
	
	ItemDetails searchItemsById(String itemId,int availableQuantity);

	boolean addItem(ItemDetails item);

	List<ItemDetails> getItemDetails();

	double generateBill();

	double getTax(ItemDetails item);

	boolean validateCustomer();

	double setTax(ItemDetails item);


}
