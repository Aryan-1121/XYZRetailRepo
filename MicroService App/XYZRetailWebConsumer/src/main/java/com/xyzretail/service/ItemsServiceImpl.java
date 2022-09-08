package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemDetailsList;
//import com.xyzretail.persistence.BasketDao;
//import com.xyzretail.persistence.PersistenceDao;
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

//	private BasketDao basketDao;
//	private PersistenceDao persistenceDao;
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	public void setBasketDao(BasketDao basketDao) {
//		this.basketDao = basketDao;
//	}
//	@Autowired
//	public void setPersistenceDao(PersistenceDao persistenceDao) {
//		this.persistenceDao = persistenceDao;
//	}

	@Override
	public ItemDetails searchItemsById(String itemId) {
//		return persistenceDao.searchItemsById(itemId);
		return null;
	}
	
	
	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		ItemDetails item=searchItemsById(id);
//		System.out.println("id ="+ id +" req qty ="+reqQuantity);
		if(item.getAvailableQuantity()>reqQuantity) 
			return true;
		System.out.println("We don't have that much quantity in our store :-(");
		return false;
	}
	
	

	@Override
	public List<ItemDetails> getAllItems() {
		
		ResponseEntity<ItemDetailsList> itemListEntity= restTemplate.getForEntity("http://itemDetails-service/itemDetail", ItemDetailsList.class);
//		http://customer-service/customers/
		return (List<ItemDetails>) itemListEntity;
	}

	@Override
	public void updateRecord(String itemID, int quantity) {
//		basketDao.updateRecord(itemID, quantity);
		
	}
	

}


