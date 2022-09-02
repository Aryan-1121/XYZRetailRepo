package com.xyzretail.service;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemsCartList;

public interface ItemsCartService {
	
	public ItemsCartList getItemsInCart(Customer user_name);

}
