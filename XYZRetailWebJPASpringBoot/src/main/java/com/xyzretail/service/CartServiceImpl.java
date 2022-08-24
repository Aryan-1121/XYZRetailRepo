package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.ItemsCartDao;
@Service("cartService")
public class CartServiceImpl implements CartService {
	private ItemsCartDao itemsCartDao;
	private ItemsService itemsService;
	
	@Autowired
	public void setItemsCartDao(ItemsCartDao itemsCartDao) {
		this.itemsCartDao = itemsCartDao;
	}
	@Autowired
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
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
//		System.out.println("customer name ="+customer);
		if (reqQuantity <1 )
		{
			System.out.println("enter positive value !!");
			return false ;
		}
		ItemDetails item=itemsService.searchItemsById(itemId);
		if(itemsService.searchItemsById(itemId, reqQuantity)) {
		
		double tax=getTax(item.getItemCategory());
		
		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();

		double totalCost=cost*reqQuantity;
		
		
		if(!itemsCartDao.searchItemById(itemId, customer)){
			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
		}
		else {
			ItemsCart itemCart=itemsCartDao.getItemById(itemId, customer);
			reqQuantity+=itemCart.getPurchaseQuantity();
			totalCost+=itemCart.getTotalCost();
			itemsCartDao.unselectFromCart(itemId, customer);
			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
		}
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
