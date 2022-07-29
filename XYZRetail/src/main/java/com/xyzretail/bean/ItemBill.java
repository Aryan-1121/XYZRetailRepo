package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemBill {

	private String itemCategory;
	private String itemName;
	private int purchaseQuantity;
	private double unitPrice;
	private double salesTax;
}
