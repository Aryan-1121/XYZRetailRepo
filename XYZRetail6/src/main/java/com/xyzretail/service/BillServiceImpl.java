package com.xyzretail.service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.ItemsBillDao;
import com.xyzretail.persistence.ItemsBillDaoImpl;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;
import com.xyzretail.persistence.TransactionDao;
import com.xyzretail.persistence.TransactionDaoImpl;
public class BillServiceImpl implements BillService {
	TransactionDao transactionDao = new TransactionDaoImpl();
	//ItemsCartDao itemsCartDao=new ItemsCartDaoImpl();

	private ItemsBillDao bill=new ItemsBillDaoImpl();
	@Override
	public ItemBill generateBill(String customer) {
		return bill.generateBill(customer); 
	}
	@Override
	public double discount(String customer) {
		if(transactionDao.monthCount(customer) > 5) {
			ItemBill itemBill=generateBill(customer);
			double discountPrice=itemBill.getGrandTotal()-(itemBill.getGrandTotal()*(double)0.15);			//	+  ->  -
			return discountPrice;
		}
		return 0;
	}

}
