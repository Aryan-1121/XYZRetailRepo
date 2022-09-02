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
	private String item_Id;
	private String item_Category;
	private String item_Name;
	private double item_Price;
	private int available_Quantity;

}
