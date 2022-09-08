package com.xyzretail.service;

import java.util.Optional;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;

public interface ItemsCartService {
	
	public ItemsCartList getItemsInCart(String name);
	public ItemsCart deleteItemByItemId(String customer,String itemId);
	public ItemsCart updateByItemId(String customer,String itemId,int requiredQuantity);
	public ItemsCart searchByItemIdAndName(String itemId,String userName);

	public ItemsCart addItemtoCart(String customer, String itemId, int requiredQuantity);
	public ItemsCartList deleteAllItemsInCart(String customer);

}
