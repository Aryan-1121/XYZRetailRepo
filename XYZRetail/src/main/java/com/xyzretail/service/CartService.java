package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemsCart;

public interface CartService {
	boolean addItemToCart(String customer,String itemId,int reqQuantity);
	void deleteItemFromCart(String itemId);
	List<ItemsCart> getAllItemsInCart(String customer);	
	public boolean modifyItemsInCart(String customer,String itemId,int modifiedQuantity);
	public int unselectFromCart(String itemId, String customer);
	
}
