package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Books extends Item {
	
	private String itemId="1";
	private String itemName="Books";
	private double itemTax=0;
	private int requestedQuantity;
	
	@Override
	public double calculateTax(Item item) {
		
		return requestedQuantity*(itemTax/100);
	}

}
