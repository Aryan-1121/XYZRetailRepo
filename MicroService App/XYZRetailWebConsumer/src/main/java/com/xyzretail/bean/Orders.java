package com.xyzretail.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Orders {
	
	
	private int transactionId;
	private String itemId;
	private int purchasedQuantity;
	
}

