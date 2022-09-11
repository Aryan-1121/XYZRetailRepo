package com.xyzretail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.persistence.ItemDetailDao;
@Service
public class ItemDetailServiceImpl implements ItemDetailService{
	
	@Autowired
	private ItemDetailDao itemDetailDao;

	@Override
	public List<ItemDetail> getAllItemDetails() {
		return itemDetailDao.findAll();
	}

	@Override
	public ItemDetail findByItemId(String itemId) {
		// TODO Auto-generated method stub
		return itemDetailDao.findById(itemId).orElse(null);
	}
	
	


	@Override
	public ItemDetail findByItemId_AndAvailable_Quantity(String itemId, int availableQuantity) {
	
			return itemDetailDao.findByItemIdAndAvailableQuantity(itemId, availableQuantity);
	
	}

	@Override
	public ItemDetail updateRecord(String itemId, int quantity) {
		ItemDetail id = itemDetailDao.findById(itemId).orElse(null);
		int updatedQuantity = id.getAvailableQuantity() - quantity;
		
		if(itemDetailDao.updateRecord(updatedQuantity,itemId)>0) {
			
			return findByItemId(itemId);
		}
		return null;
		
	}

	

}
