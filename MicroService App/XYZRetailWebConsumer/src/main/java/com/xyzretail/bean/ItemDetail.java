package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemDetail {

	private String itemId;
	private String itemCategory;
	private String itemName;
	private double itemPrice;
	private int availableQuantity;

}
