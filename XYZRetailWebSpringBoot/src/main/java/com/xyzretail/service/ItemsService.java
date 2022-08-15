package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;


public interface ItemsService {

	
	
	boolean searchItemsById(String itemId,int reqQuantity);
	public void updateRecord(String itemID , int quantity);
	ItemDetails searchItemsById(String itemId);
//	boolean searchItemById(String itemId, String customer);
//	ItemsCart getItemById(String itemId,String customer) ;

	List<ItemDetails> getAllItems();

}
