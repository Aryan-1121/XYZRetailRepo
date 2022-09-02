package com.xyzretail.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.Item_Detail;
import com.xyzretail.model.persistence.Item_DetailDao;
@Service
public class Item_DetailServiceImpl implements Item_DetailService{
	
	@Autowired
	private Item_DetailDao item_DetailDao;

	@Override
	public List<Item_Detail> getAllItemDetails() {
		return item_DetailDao.findAll();
	}

	

}
