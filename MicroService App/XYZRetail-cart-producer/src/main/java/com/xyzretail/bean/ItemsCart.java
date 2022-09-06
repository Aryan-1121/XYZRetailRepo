package com.xyzretail.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemsCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartid;
	private String itemId;
	private String itemName;
	private double unitPrice;
	private String userName;
	private int requiredQuantity;
	private double salesTax;
	private double totalCost;
	
}
