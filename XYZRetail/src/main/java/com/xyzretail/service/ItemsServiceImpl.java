package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Item;

public class ItemsServiceImpl implements ItemsService {

	@Override
	public double getBooksCost(int requiredBooks) {
		return 0;
	}

	@Override
	public double getCdCost(int requiredCds) {
		return 0;
	}

	@Override
	public double getCosmeticsCost(int requiredCosmetics) {
		return 0;
	}

	@Override
	public double generateBill() {
		return 0;
	}

	@Override
	public List<Item> getAllItems() {
		return null;
	}

	@Override
	public Item searchItemsById(String id, int reqQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
