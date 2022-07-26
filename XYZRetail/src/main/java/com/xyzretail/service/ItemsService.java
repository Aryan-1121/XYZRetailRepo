package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Item;

public interface ItemsService {
	double getBooksCost(int requiredBooks);
	double getCdCost(int requiredCds);
	double getCosmeticsCost(int requiredCosmetics);
	double generateBill();
	List<Item> getAllItems();
	Item searchItemsById(String id,int reqQuantity);
}
