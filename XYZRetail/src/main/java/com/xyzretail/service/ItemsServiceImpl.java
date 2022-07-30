package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.*;

public class ItemsServiceImpl implements ItemsService {

	private BasketDao basketDao = new BasketDaoImpl();
	private PersistenceDao persistenceDao=new PersistenceDaoImpl();
	//private CartService cartService=new CartServiceImpl();

	@Override
	public double setTax(ItemDetails item) {
		double tax=0;
		if(item.getItemCategory()=="books")
		{
			tax=item.getItemPrice()*0.10;
		}
		else if(item.getItemCategory()=="cosmetics")
		{
			 tax=item.getItemPrice()*0.30;
		}
		else if(item.getItemCategory()=="CD")
		{
			tax=item.getItemPrice()*0.20;
		}
		return tax;
	}
	

	@Override
	public double generateBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTax(ItemDetails item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemDetails searchItemsById(String itemId) {
		
		return persistenceDao.searchItemsById(itemId);
	}
	
	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		return persistenceDao.searchItemsById(id, reqQuantity);
	}

//	@Override
//	public boolean addItemToCart(String itemId, int reqQuantity) {
//		return cartService.addItemToCart(itemId, reqQuantity);
//	}
//
//	@Override
//	public List<ItemsCart> getAllItemsFromCart() {
//		return cartService.getAllItemsInCart();
//	}

	@Override
	public List<ItemDetails> getAllItems() {
		return basketDao.getAllItems();
	}

	

}


