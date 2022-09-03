package com.xyzretail.service;

import java.util.Optional;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;

public interface ItemsCartService {
	
	public ItemsCartList getItemsInCart(Customer user_name);
	public ItemsCart deleteItemByItemId(Customer customer,String itemId);
	public ItemsCart updateByItemId(Customer customer,String itemId,int requiredQuantity);
	public Optional<ItemsCart> searchByItemIdAndName(Customer customer,String itemId);
}
