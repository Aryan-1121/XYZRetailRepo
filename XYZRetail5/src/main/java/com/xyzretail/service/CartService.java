package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemsCart;

public interface CartService {
	boolean addItemToCart(String customer,String itemId,int reqQuantity);
	boolean deleteItemFromCart(String itemId);
	List<ItemsCart> getAllItemsInCart(String customer);

}
