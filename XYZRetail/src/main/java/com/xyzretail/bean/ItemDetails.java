package com.xyzretail.bean;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class ItemDetails {

	private String itemId;
	private String itemCategory;
	private String itemName;
	private double itemPrice;
	private int availableQuantity;
	
}
