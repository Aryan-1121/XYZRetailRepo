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

}
