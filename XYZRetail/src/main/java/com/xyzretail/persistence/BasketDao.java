package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.Item;

public interface BasketDao {

	int addItem(Item item);
	boolean updateRecord(String itemID);
	List<Item> getAllItems();
	//int searchAvailabeQuantity(String item_Id);
	Item searchItemById(String item_id);
	
	
}
