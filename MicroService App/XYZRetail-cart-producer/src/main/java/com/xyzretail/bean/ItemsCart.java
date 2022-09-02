package com.xyzretail.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@OneToMany
	private String item_id;
	private String user_Name;
	private int requiredQuantity;
	private double salesTax;
	private double totalCost;
	
}
