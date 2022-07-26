package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public abstract class Item {

	private String itemId;
	private double itemPrice;
	private int quantityLeft;
	private int quantitySold;
	
	public double calculateTax(Item item) {
		return 0;};
}
