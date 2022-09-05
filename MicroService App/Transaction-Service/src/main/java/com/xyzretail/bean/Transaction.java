package com.xyzretail.bean;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String customerName;
//	private String itemId;
//	private String itemCategory;
//	private String itemName;
//	private double itemPrice;
//	private int availableQuantity;
//	private int purchaseQuantity;
//	private double salesTax;
//	private double totalCost;
	private Date date;
	private Time time;
	
	
}
