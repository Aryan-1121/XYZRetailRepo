package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.ItemDetails;

public interface PersistenceDao {

	boolean updateQuantity(int purchasedQuantity);
	ItemDetails searchItemsById(String id);
	boolean searchItemsById(String id,int reqQuantity);
	List<ItemDetails> getAllItems();
}
