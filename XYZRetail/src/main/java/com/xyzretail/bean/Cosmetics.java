package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Cosmetics extends Item {

	private String itemName="Cosmetics";
	private double salesTax;
	private int requestedQuantity;
	
	public double calculateTax(Item item) {
		
		return requestedQuantity*(salesTax/100);
	}

}
