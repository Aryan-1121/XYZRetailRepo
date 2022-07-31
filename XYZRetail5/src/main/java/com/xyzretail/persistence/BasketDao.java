package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.*;

public interface BasketDao {

	int addItem(ItemDetails item);
	boolean updateRecord(String itemID);
	List<ItemDetails> getAllItems();				//done 
	ItemDetails searchItemById(String item_id);
		
}
