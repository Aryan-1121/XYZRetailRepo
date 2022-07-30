package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsCart {
	
	private ItemDetails item;
	private Customer customer;
	private Transaction transactionId;
	private int purchaseQuantity;
	private double salesTax;
	private double totalCost;
	
	
}
