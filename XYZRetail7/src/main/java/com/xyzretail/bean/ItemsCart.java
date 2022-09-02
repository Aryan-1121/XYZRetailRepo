package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsCart {
	
	private ItemDetails item;
	private String customer;
	private int purchaseQuantity;
	private double salesTax;
	private double totalCost;
	
	
}
