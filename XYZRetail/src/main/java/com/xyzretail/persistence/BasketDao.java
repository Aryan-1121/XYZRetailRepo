package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.*;

public interface BasketDao {

	int addItem(Item item);
	boolean updateRecord(String itemID);
	List<Item> getAllItems();
	Item searchItemById(String item_id);
		
}
