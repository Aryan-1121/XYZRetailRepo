package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.Transaction;

public interface ItemsCartDao {
	public boolean addItemToCart(ItemDetails item, Customer customer, Transaction transactionId,int reqQuantity, double tax, double totalCost );
	boolean deleteItemFromCart(String itemId);
	List<ItemsCart> getAllItemsInCart();
}
