package com.xyzretail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.BasketDao;
import com.xyzretail.persistence.BasketDaoImpl;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;
import com.xyzretail.persistence.PersistenceDao;
import com.xyzretail.persistence.PersistenceDaoImpl;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

	private BasketDao basketDao;
	private PersistenceDao persistenceDao;
	private ItemsCartDao itemsCartDao;

	
	
	public void setBasketDao(BasketDao basketDao) {
		this.basketDao = basketDao;
	}

	public void setPersistenceDao(PersistenceDao persistenceDao) {
		this.persistenceDao = persistenceDao;
	}

	public void setItemsCartDao(ItemsCartDao itemsCartDao) {
		this.itemsCartDao = itemsCartDao;
	}

	@Override
	public ItemDetails searchItemsById(String itemId) {
		
		return persistenceDao.searchItemsById(itemId);
	}
	
	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		return persistenceDao.searchItemsById(id, reqQuantity);
	}

	@Override
	public List<ItemDetails> getAllItems() {
		return basketDao.getAllItems();
	}

	@Override
	public void updateRecord(String itemID, int quantity) {
		basketDao.updateRecord(itemID, quantity);
	}



	

}


