package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.*;

public interface BasketDao {

	int addItem(ItemDetails item);
	void updateRecord(String itemID, int quantity);
	List<ItemDetails> getAllItems();				//done 
		
}
