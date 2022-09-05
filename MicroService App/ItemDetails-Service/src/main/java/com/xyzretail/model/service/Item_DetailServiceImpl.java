package com.xyzretail.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.model.persistence.Item_DetailDao;
@Service
public class Item_DetailServiceImpl implements Item_DetailService{
	
	@Autowired
	private Item_DetailDao item_DetailDao;

	@Override
	public List<ItemDetail> getAllItemDetails() {
		return item_DetailDao.findAll();
	}

	@Override
	public Optional<ItemDetail> findByItemId(String itemId) {
		// TODO Auto-generated method stub
		return item_DetailDao.findById(itemId);
	}
	
	

	

}
