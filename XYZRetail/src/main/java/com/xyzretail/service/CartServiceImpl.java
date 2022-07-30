package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;

public class CartServiceImpl implements CartService {
	private ItemsCartDao itemsCartDao=new ItemsCartDaoImpl();
	private ItemsService itemsService=new ItemsServiceImpl();

	@Override
	public List<ItemsCart> getAllItemsInCart() {
		return itemsCartDao.getAllItemsInCart();
	}

	@Override
	public boolean addItemToCart(String itemId, int reqQuantity) {
	if(itemsService.searchItemsById(itemId, reqQuantity)) {
		ItemDetails item=itemsService.searchItemsById(itemId);
		int tax;
		switch(item.getItemCategory()) {
		case "Book":
		case "Books":
			tax=0;
			break;
		case "CD":
		case "CDS" :
			tax=10;
			break;
		case "Cosmetics":
			tax=12;
			break;
		default:
			tax=0;
			break;
		}
		double cost=(item.getItemPrice()*(tax/100))+item.getItemPrice();
		double totalCost=cost*reqQuantity;
		
		return itemsCartDao.addItemToCart(item, reqQuantity, tax, totalCost);
		}
		return false;
	}

	@Override
	public boolean deleteItemFromCart(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

}
