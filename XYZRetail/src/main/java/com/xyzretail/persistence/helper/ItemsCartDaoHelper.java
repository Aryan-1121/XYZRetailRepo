package com.xyzretail.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.PersistenceDao;

@Repository
public class ItemsCartDaoHelper implements RowMapper<ItemsCart> {
	PersistenceDao persistenceDao;
	

	@Autowired
	public void setPersistenceDao(PersistenceDao persistenceDao) {
		this.persistenceDao = persistenceDao;
	}


	@Override
	public ItemsCart mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String itemId=resultSet.getString("ItemId");
		String userName = resultSet.getString("User_Name");
		int reqQuantity=resultSet.getInt("requiredQuantity");
		double tax=resultSet.getDouble("Tax");
		double cost=resultSet.getDouble("totalCost");

		System.out.println( "serach item by id op :"+persistenceDao.searchItemsById(itemId));
		ItemsCart cart=new ItemsCart(persistenceDao.searchItemsById(itemId),userName,reqQuantity,tax,cost);
//		ItemsCart cart=new ItemsCart(itemId,userName,reqQuantity,tax,cost);
		System.out.println("cart in icHepler :"+cart);
		
		return cart;
		
	}

}
