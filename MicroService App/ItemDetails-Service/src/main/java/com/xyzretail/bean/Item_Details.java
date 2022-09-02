package com.xyzretail.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item_Details {
	List<Item_Detail> item_Details;
}
