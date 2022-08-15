package com.xyzretail.persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.xyzretail.bean.ItemDetails;

@Component("rowMapper")
public class ItemsRowMapper implements RowMapper<ItemDetails> {


	@Override
	public ItemDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		String itemId = resultSet.getString("item_Id");
		String itemCategory=resultSet.getString("item_Category");
		String itemName = resultSet.getString("Item_Name");
		double item_Price = resultSet.getDouble("Item_Price");
		int availableQuantity=resultSet.getInt("Available_Quantity");
		
		ItemDetails itemDetails = new ItemDetails(itemId,itemCategory,itemName,item_Price,availableQuantity);
		
		return itemDetails;
	}
}

