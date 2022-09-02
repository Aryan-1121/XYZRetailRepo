package com.xyzretail.persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.PersistenceDao;

public class ItemsCartRowMapper implements RowMapper<ItemsCart>{

	@Autowired
	private PersistenceDao persistenceDao; 


	@Override
	public ItemsCart mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String itemId=resultSet.getString("ItemId");
		String userName = resultSet.getString("User_Name");
		int reqQuantity=resultSet.getInt("requiredQuantity");
		double tax=resultSet.getDouble("Tax");
		double cost=resultSet.getDouble("totalCost");
		System.out.println(persistenceDao.searchItemsById(itemId));
		ItemsCart cart=new ItemsCart(persistenceDao.searchItemsById(itemId),userName,reqQuantity,tax,cost);
		
		return cart;
	}
}
