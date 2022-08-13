package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.BasketDao;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.PersistenceDao;
@Service
public class ItemsServiceImpl implements ItemsService {

	private BasketDao basketDao;
	private PersistenceDao persistenceDao;
	private ItemsCartDao itemsCartDao;
	
	
	@Autowired
	public void setBasketDao(BasketDao basketDao) {
		this.basketDao = basketDao;
	}
	@Autowired
	public void setPersistenceDao(PersistenceDao persistenceDao) {
		this.persistenceDao = persistenceDao;
	}

	@Override
	public ItemDetails searchItemsById(String itemId) {
		return persistenceDao.searchItemsById(itemId);
	}
	
	
	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		ItemDetails item=searchItemsById(id);
		if(item.getAvailableQuantity()>reqQuantity) 
			return true;
		System.out.println("We don't have that much quantity in our store :-(");
		return false;
	}
	
	

	@Override
	public List<ItemDetails> getAllItems() {
		return basketDao.getAllItems();
	}

	@Override
	public void updateRecord(String itemID, int quantity) {
		basketDao.updateRecord(itemID, quantity);
	}
//	@Override
//	public boolean searchItemById(String itemId, String customer) {
//	
//		List<ItemsCart> cart=itemsCartDao.getAllItemsInCart(customer);
//		for(ItemsCart item:cart) {
//			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
//				return true;
//		}
//		return false;
//	}
//	@Override
//	public ItemsCart getItemById(String itemId, String customer) {
//
//		List<ItemsCart> cart=itemsCartDao.getAllItemsInCart(customer);
//		for(ItemsCart item:cart) {
//			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
//				return item;
//		}
//		return null;
//	}



	

}


