package com.xyzretail.bean;

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
	private Date date;
	
}
