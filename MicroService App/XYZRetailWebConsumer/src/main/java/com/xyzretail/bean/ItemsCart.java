package com.xyzretail.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemsCart {
	
	
	private int cartid;
	private String itemId;
	private String itemName;
	private double unitPrice;
	private String userName;
	private int requiredQuantity;
	private double salesTax;
	private double totalCost;
	
}
