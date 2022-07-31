package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.ItemsBillDao;
import com.xyzretail.persistence.ItemsBillDaoImpl;
public class BillServiceImpl implements BillService {

	private ItemsBillDao bill=new ItemsBillDaoImpl();
	@Override
	public ItemBill generateBill(String customer) {
		return bill.generateBill(customer); 
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
