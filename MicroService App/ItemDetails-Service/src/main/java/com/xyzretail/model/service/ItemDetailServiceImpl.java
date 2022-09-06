package com.xyzretail.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.model.persistence.ItemDetailDao;
@Service
public class ItemDetailServiceImpl implements ItemDetailService{
	
	@Autowired
	private ItemDetailDao itemDetailDao;

	@Override
	public List<ItemDetail> getAllItemDetails() {
		return itemDetailDao.findAll();
	}

	@Override
	public Optional<ItemDetail> findByItemId(String itemId) {
		// TODO Auto-generated method stub
		return itemDetailDao.findById(itemId);
	}
	
	


	@Override
	public ItemDetail findByItemId_AndAvailable_Quantity(String itemId, int availableQuantity) {
	
			return itemDetailDao.findByItemIdAndAvailableQuantity(itemId, availableQuantity);
	
	}

	

}
