package com.xyzretail.service;

import java.util.List;

import com.xyzretail.client.Customer;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.*;

public class ItemsServiceImpl implements ItemsService {

	private BasketDao basketDao = new BasketDaoImpl();

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

		return basketDao.getAllItems();

	}

	@Override
	public ItemDetails searchItemsById(String id, int reqQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addItem(ItemDetails item) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public List<ItemDetails> getItemDetails() {
		// TODO Auto-generated method stub
		return null;
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




}


