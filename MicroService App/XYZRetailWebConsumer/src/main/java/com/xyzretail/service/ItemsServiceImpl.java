package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemDetail;
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
	public ItemDetail searchItemsById(String itemId) {
		ItemDetail item=restTemplate.getForObject("http://itemDetails-Cart-service/itemDetail/"+itemId,ItemDetail.class);
		if(item!=null) {
			return item;
		}
		return new ItemDetail();
	}
	
	
	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		ItemDetail item=searchItemsById(id);
		if(item!=null) {
		ItemDetail item1=restTemplate.getForObject("http://itemDetails-Cart-service/itemDetail/"+id+reqQuantity,ItemDetail.class);
		if(item1!=null) {
			return true;
		}
		else {
			return false;
		}
		
		}
		return false;
		
	}

	@Override
	public void updateRecord(String itemID, int quantity) {
	}


	@Override
	public List<ItemDetail> getAllItems() {
		ResponseEntity<ItemDetailsList> itemDetailsList=restTemplate.getForEntity("http://itemDetails-Cart-service/itemDetail",ItemDetailsList.class);
		List<ItemDetail> itemDetails=itemDetailsList.getBody().getItemDetails();
		System.out.println(itemDetailsList);
		System.out.println(itemDetails);
		return itemDetails;

	}

	

}


