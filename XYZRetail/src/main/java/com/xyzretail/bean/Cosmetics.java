package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@EqualsAndHashCode
public class Cosmetics extends Item {

	private String itemId="3";
	private String itemName="Cosmetics";
	private double itemTax=12;
	private int requestedQuantity;
	
	@Override
	public double calculateTax(Item item) {
		
		return requestedQuantity*(itemTax/100);
	}

}
