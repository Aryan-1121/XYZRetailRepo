package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;

public class ItemsServiceImpl implements ItemsService {


	@Override
	public double setTax(ItemDetails item) {
		double tax=0;
		if(item.getItemCategory()=="books")
		{
			tax=item.getItemPrice()*0.10;
		}
		else if(item.getItemCategory()=="cosmetics")
		{
			 tax=item.getItemPrice()*0.30;
		}
		else if(item.getItemCategory()=="CD")
		{
			tax=item.getItemPrice()*0.20;
		}
		return tax;
	}

	@Override
	public List<ItemDetails> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDetails searchItemsById(String itemId, int availableQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(ItemDetails item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemDetails> getItemDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double generateBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTax(ItemDetails item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateCustomer() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double calculateBooksCost(ItemDetails item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateCDCost(ItemDetails item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateCosmeticsCost(ItemDetails item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateTaxAmount(ItemDetails category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBooksCost(int requiredBooks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCdCost(int requiredCds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getCosmeticsCost(int requiredCosmetics) {
		// TODO Auto-generated method stub
		return 0;
	}

}


