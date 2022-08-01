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
	public List<ItemsCart> getAllItemsInCart(String customer) {
		return itemsCartDao.getAllItemsInCart(customer);
	}

	@Override
	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
		
//		System.out.println("entered in addItemsToCart in cartServiceImplementation");
	
		ItemDetails item=itemsService.searchItemsById(itemId);
	if(itemsService.searchItemsById(itemId, reqQuantity)) {
		
//		System.out.println("inside if stmnt of cartServiceImpl  ( !itemsService.searchItemsById(itemId, reqQuantity).equals(null)");

		int tax;
		switch(item.getItemCategory()) {
		case "Books":
		
			tax=0;
			break;
		case "CD"  :
		
			tax=10;
			break;
		case "COSMETICS":
		
			tax=12;
			break;
		default:
			tax=0;
			break;
		}
		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();

		double totalCost=cost*reqQuantity;
//		System.out.println(totalCost);		//check
		System.out.println();
		return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
		}
	else {

		System.out.println(reqQuantity+" "+ item.getItemName() +" is Not available in our Stock :( ");
		return false;
	}
	}


	
	@Override
	public void deleteItemFromCart(String customer) {
		itemsCartDao.deleteItemFromCart(customer);
	}

	@Override
	public int unselectFromCart(String itemId, String customer) {
		return itemsCartDao.unselectFromCart(itemId, customer);
		
	}

}
