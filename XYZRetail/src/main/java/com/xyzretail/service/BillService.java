package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;

public interface BillService {
	
	
	ItemBill generateBill(String customer);

	public void getTax(ItemDetails item);
	
	double setTax(ItemDetails item);

	double calculateCost(ItemDetails details);

	double calculateTaxAmount(ItemDetails category);

}
