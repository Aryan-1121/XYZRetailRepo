package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemDetail;





public interface ItemsService {

	
	
	boolean searchItemsById(String itemId,int reqQuantity);
	public void updateRecord(String itemID , int quantity);
	ItemDetail searchItemsById(String itemId);
//	boolean searchItemsById(String itemId,int reqQuantity);
//	public void updateRecord(String itemID , int quantity);
//	ItemDetails searchItemsById(String itemId);
//	boolean searchItemById(String itemId, String customer);
//	ItemsCart getItemById(String itemId,String customer) ;

	List<ItemDetail> getAllItems();


}
