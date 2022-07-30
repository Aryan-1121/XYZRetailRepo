package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;

public interface ItemsCartDao {
	boolean addItemToCart(ItemDetails item,int reqQuantity,double tax,double totalCost);
	boolean deleteItemFromCart(String itemId);
	List<ItemsCart> getAllItemsInCart();
}
