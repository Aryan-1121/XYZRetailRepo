package com.xyzretail.bean;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

	private int transactionId;
	private String customerName;
	private ItemsCart cart;
	private Date date;
	private Time time;
	
}
