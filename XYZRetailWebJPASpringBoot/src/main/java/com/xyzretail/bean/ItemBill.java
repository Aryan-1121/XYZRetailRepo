package com.xyzretail.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemBill {

	private String customerName;
	private List<ItemsCart> cart;
	private double grandTotal;
		
}

//iterm