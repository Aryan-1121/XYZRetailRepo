package com.xyzretail.persistence;

import com.xyzretail.bean.ItemDetails;

public interface PersistenceDao {
	ItemDetails searchItemsById(String id);
}
