package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;


public interface BillService {
	
	
	ItemBill generateBill(String customer);
}
