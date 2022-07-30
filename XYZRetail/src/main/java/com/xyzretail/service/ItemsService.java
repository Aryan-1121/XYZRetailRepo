package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;


public interface ItemsService {

	
	
	boolean searchItemsById(String itemId,int reqQuantity);
	ItemDetails searchItemsById(String itemId);
	

//	boolean addItemToCart(String itemId,int reqQuantity);
//	List<ItemsCart> getAllItemsFromCart();
	List<ItemDetails> getAllItems();

	double generateBill();

	double getTax(ItemDetails item);

	boolean validateCustomer();

	double setTax(ItemDetails item);


}
