package com.xyzretail.bean;

import java.util.ArrayList;
import java.util.List;

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
	@OneToMany(targetEntity=ItemDetail.class)
	private List<ItemDetail> itemDetail =new ArrayList<ItemDetail>();
	private String user_Name;
	private int requiredQuantity;
	private double salesTax;
	private double totalCost;
	
}
