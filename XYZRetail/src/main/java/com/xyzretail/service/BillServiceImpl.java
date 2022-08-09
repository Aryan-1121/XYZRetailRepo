package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.ItemsBillDao;
import com.xyzretail.persistence.ItemsBillDaoImpl;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.ItemsCartDaoImpl;
import com.xyzretail.persistence.TransactionDao;
import com.xyzretail.persistence.TransactionDaoImpl;

@Component("billService")
public class BillServiceImpl implements BillService {
	TransactionDao transactionDao;
	//ItemsCartDao itemsCartDao=new ItemsCartDaoImpl();

	ItemsBillDao bill;
	
	
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	public void setBill(ItemsBillDao bill) {
		this.bill = bill;
	}
	
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
