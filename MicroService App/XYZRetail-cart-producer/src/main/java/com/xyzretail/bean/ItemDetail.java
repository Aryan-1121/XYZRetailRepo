package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemDetail {
	
	private String itemId;
	private String itemCategory;
	private String itemName;
	private double itemPrice;
	private int availableQuantity;

}

