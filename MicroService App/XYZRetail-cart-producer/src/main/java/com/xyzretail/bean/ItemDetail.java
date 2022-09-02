package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetail {
	private String item_Id;
	private String item_Category;
	private String item_Name;
	private double item_Price;
	private int available_Quantity;

}
