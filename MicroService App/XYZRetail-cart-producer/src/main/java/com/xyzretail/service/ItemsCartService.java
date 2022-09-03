package com.xyzretail.service;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;

public interface ItemsCartService {
	
	public ItemsCartList getItemsInCart(Customer user_name);
	public ItemsCart addItemtoCart(Customer customer,String itemId,int requiredQuantity);
	
}
