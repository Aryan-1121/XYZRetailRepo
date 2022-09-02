package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;

public interface BillService {
	
	
	ItemBill generateBill(String customer);
	

	double discount(String customer);



}
