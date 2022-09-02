package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.persistence.TransactionDao;

@Component("billService")
public class BillServiceImpl implements BillService {
	TransactionDao transactionDao;

	private ItemsCartDao cart;
	
	@Autowired
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Autowired
	public void setCart(ItemsCartDao cart) {
		this.cart = cart;
	}
	@Override
	public ItemBill generateBill(String customer) {
		List<ItemsCart> item=cart.getAllItemsInCart(customer);
		ItemBill bill;
		double grandTotal=0;
		for(ItemsCart items:item) {
			grandTotal+=items.getTotalCost();
		}
		bill=new ItemBill(customer,item,grandTotal);
		return bill;
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
