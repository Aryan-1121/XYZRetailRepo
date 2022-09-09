package com.xyzretail.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int OrderId;
	private int transactionId;
	private String itemId;
	private int purchasedQuantity;
	
}

