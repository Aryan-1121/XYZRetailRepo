package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xyzretail.bean.ItemDetails;

public class PersistenceDaoImpl implements PersistenceDao {

	@Override
	public boolean updateQuantity(int purchasedQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemDetails searchItemsById(String id) {
		ItemDetails item;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM Item_Details where Item_Id= ?");) {
			
		
			preparedStatement.setString(1,id);
			
			
			ResultSet items=preparedStatement.executeQuery();
			
			
			items.next();
			String itemId = items.getString("item_Id");
     		String itemCategory=items.getString("item_Category");
			String itemName = items.getString("Item_Name");
			double item_Price = items.getDouble("Item_Price");
			int availableQuantity=items.getInt("Available_Quantity");
			
			item=new ItemDetails(itemId,itemCategory,itemName,item_Price,availableQuantity);
					
		}catch (SQLException e) {
			return null;
		
		}
		return item;
	}

	@Override
	public List<ItemDetails> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		

		ItemDetails item=searchItemsById(id);


		if(item.getAvailableQuantity()>reqQuantity) {
			return true;
		}
		System.out.println("We don't have that much quantity in our store :(");

		return false;
	}

}
