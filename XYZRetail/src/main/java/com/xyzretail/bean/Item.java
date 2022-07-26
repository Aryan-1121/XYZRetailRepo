package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data

public class Item {

	private String itemId;
	private String itemName;
	private double itemPrice;
	private double itemTax;
	private int itemLeft;
	private int itemSold;
//	public Item(String itemName,double itemPrice,int itemLeft){
//		this.itemName=itemName;
//		this.itemPrice=itemPrice;
//		this.itemLeft=itemLeft;
//	}
	public double calculateTax(Item item) {
		return 0;};
}
