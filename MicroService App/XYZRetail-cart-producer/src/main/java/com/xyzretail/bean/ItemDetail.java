package com.xyzretail.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemDetail {
	@Id
	private String itemId;
	private String itemCategory;
	private String itemName;
	private double itemPrice;
	private int availableQuantity;


}
