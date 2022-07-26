package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class CD extends Item {

	private String itemId="2";
	private String itemName="CD";
	private double itemTax=10;
	private int requestedQuantity;
	
	@Override
	public double calculateTax(Item item) {
		
		return requestedQuantity*(itemTax/100);
	}

}
