package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.ItemDetails;

public interface persistenceDao {

	boolean updateQuantity(int purchasedQuantity);
	ItemDetails searchItemsById(int id);
	List<ItemDetails> getAllItems();
}
