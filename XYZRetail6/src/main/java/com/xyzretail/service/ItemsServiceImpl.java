package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.BasketDao;
import com.xyzretail.persistence.BasketDaoImpl;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;
import com.xyzretail.persistence.PersistenceDao;
import com.xyzretail.persistence.PersistenceDaoImpl;

public class ItemsServiceImpl implements ItemsService {

	private BasketDao basketDao = new BasketDaoImpl();
	private PersistenceDao persistenceDao=new PersistenceDaoImpl();
	private ItemsCartDao itemsCartDao = new ItemsCartDaoImpl();

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


