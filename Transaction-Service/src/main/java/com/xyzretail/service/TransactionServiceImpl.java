package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.Transaction;
import com.xyzretail.persistence.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private TransactionDao transactionDao;

	@Override
	public Transaction performTransaction(String customer) {
		// TODO Auto-generated method stub
		Transaction t=new Transaction();
		int rows=transactionDao.saveTransaction(t.getTransactionId(),t.getCustomerName(), t.getItemId(), t.getItemCategory(), 
				t.getItemName(),t.getItemPrice(),t.getAvailableQuantity(),t.getPurchaseQuantity(),t.getSalesTax(),t.getTotalCost(),t.getDate(),t.getTime());
		if(rows>0) {
			return transactionDao.findById(t.getTransactionId()).get();
		}
		return new Transaction();
	}
	
	
	
	
//	private int transactionId;
//	private String customerName;
//	private String itemId;
//	private String itemCategory;
//	private String itemName;
//	private double itemPrice;
//	private int availableQuantity;
//	private int purchaseQuantity;
//	private double salesTax;
//	private double totalCost;
//	private Date date;
//	private Time time;
	
	
}
