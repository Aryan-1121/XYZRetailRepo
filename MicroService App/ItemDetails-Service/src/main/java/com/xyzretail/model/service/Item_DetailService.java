package com.xyzretail.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemDetailsList;
@Service
public interface Item_DetailService {
	List<ItemDetail>  getAllItemDetails();
}
