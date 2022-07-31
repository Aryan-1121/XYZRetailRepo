package com.xyzretail.service;

import com.xyzretail.bean.ItemDetails;

public interface BillService {
	
	
	double generateBill();

	public void getTax(ItemDetails item);
	
	double setTax(ItemDetails item);

	double calculateCost(ItemDetails details);

	double calculateTaxAmount(ItemDetails category);

}
