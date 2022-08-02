package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;

public class CartServiceImpl implements CartService {
	private ItemsCartDao itemsCartDao=new ItemsCartDaoImpl();
	private ItemsService itemsService=new ItemsServiceImpl();

	private double getTax(String itemCategory) {
		int tax;
		switch(itemCategory) {
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
		return tax;
	}
	@Override
	public List<ItemsCart> getAllItemsInCart(String customer) {
		return itemsCartDao.getAllItemsInCart(customer);
	}

	@Override
	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
		
		if (reqQuantity <1 )
		{
			System.out.println("enter positive value !!");
			return false ;
		}
//		System.out.println("entered in addItemsToCart in cartServiceImplementation");
	
		ItemDetails item=itemsService.searchItemsById(itemId);
	if(itemsService.searchItemsById(itemId, reqQuantity)) {
		
		double tax=getTax(item.getItemCategory());
		
		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();

		double totalCost=cost*reqQuantity;
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

	@Override
	public boolean modifyItemsInCart(String customer, String itemId, int modifiedQuantity) {
		if(modifiedQuantity <1) {
			System.out.println("enter positive value greater than 0");
			return false;
		}
		
		
		
		if(itemsService.searchItemsById(itemId, modifiedQuantity) && itemsCartDao.searchItemById(itemId, customer)) {
			ItemDetails item=itemsService.searchItemsById(itemId);	
			double tax=getTax(item.getItemCategory());
			
			double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();

			double totalCost=cost*modifiedQuantity;
		
			
			itemsCartDao.modifyQuantityOfCartItems(customer, itemId, modifiedQuantity, tax ,totalCost);
			return true;
		}
		return false;
	}

}
