package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xyzretail.bean.ItemDetails;

public class BasketDaoImpl implements BasketDao{

	
	@Override
	public int addItem(ItemDetails item) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO BASKET values(?,?,?,?,?,?)");) {
			
			

			preparedStatement.setString(1, item.getItemId());
			preparedStatement.setString(2,item.getItemCategory());
			preparedStatement.setString(3, item.getItemName());
			preparedStatement.setDouble(4, item.getItemPrice());
			preparedStatement.setInt(5, item.getAvailableQuantity());
			

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}


	

	@Override
	public void updateRecord(String itemID , int quantity) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				PreparedStatement preparedStatement = connection
						.prepareStatement("update item_Details " + 
						"set Available_Quantity=  Available_Quantity - ? " + 
						"where Item_Id = ? ;");) {
			
			preparedStatement.setInt(1, quantity);
			preparedStatement.setString(2, itemID);
			
			preparedStatement.executeUpdate();
			
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		

	}

	
	
	
	@Override
	public List<ItemDetails> getAllItems() {
		
		List<ItemDetails> itemList = new ArrayList<ItemDetails>();

		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Item_Details");

			while (resultSet.next()) {
     			String itemId = resultSet.getString("item_Id");
     			String itemCategory=resultSet.getString("item_Category");
				String itemName = resultSet.getString("Item_Name");
				double item_Price = resultSet.getDouble("Item_Price");
				int availableQuantity=resultSet.getInt("Available_Quantity");
				

				itemList.add(new ItemDetails(itemId,itemCategory,itemName,item_Price,availableQuantity));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;
	}


//	@Override
//	public ItemDetails searchItemById(String item_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
