package com.xyzretail.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemDetailsList;
@Service
public interface Item_DetailService {
	List<ItemDetail>  getAllItemDetails();
	
	Optional<ItemDetail> findByItemId(String itemId);
	
	ItemDetail findByItemId_AndAvailable_Quantity(String itemId,int availableQuantity);
}
