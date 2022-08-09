package com.xyzretail.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xyzretail.bean.ItemDetails;

public class BasketDaoHelper implements RowMapper<ItemDetails> {

	@Override
	public ItemDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String itemId = resultSet.getString("item_Id");
		String itemCategory=resultSet.getString("item_Category");
		String itemName = resultSet.getString("Item_Name");
		double item_Price = resultSet.getDouble("Item_Price");
		int availableQuantity=resultSet.getInt("Available_Quantity");
		

		ItemDetails item=new ItemDetails(itemId,itemCategory,itemName,item_Price,availableQuantity);
		return item;
	}

}
