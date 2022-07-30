package com.xyzretail.service;

import com.xyzretail.bean.ItemDetails;
public class BillServiceImpl implements BillService {

	@Override
	public double generateBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public  void getTax(ItemDetails item) {

		
		
	}

	@Override
	public double setTax(ItemDetails item) {

		
		double tax=0;
		if(item.getItemCategory()=="books")
		{
	           tax=item.getItemPrice();
		}
		else if(item.getItemName()=="cosmetics")
		{
			 tax=item.getItemPrice()*0.30;
		}
		else if(item.getItemName()=="CD")
		{
			tax=item.getItemPrice()*0.20;
		}
		return tax;		
		
		
		
	}

	@Override
	public double calculateCost(ItemDetails details) {

		
		double itemBookPrice;
		double itemCDPrice;
		double itemCosmiticsPrice;
		
		return 0;
	}

	@Override
	public double calculateTaxAmount(ItemDetails category) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
