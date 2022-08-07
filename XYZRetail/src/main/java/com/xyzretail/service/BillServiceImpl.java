package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.ItemsBillDao;
import com.xyzretail.persistence.ItemsBillDaoImpl;
import com.xyzretail.persistence.TransactionDao;
import com.xyzretail.persistence.TransactionDaoImpl;
public class BillServiceImpl implements BillService {
	TransactionDao transactionDao = new TransactionDaoImpl();

	private ItemsBillDao bill=new ItemsBillDaoImpl();
	@Override
	public ItemBill generateBill(String customer) {
		return bill.generateBill(customer); 
	}
	@Override
	public boolean discount(String customer) {
		if(transactionDao.monthCount(customer) > 5) {
//			bill
			return true;
		}
		
		
		return false;
	}

}
