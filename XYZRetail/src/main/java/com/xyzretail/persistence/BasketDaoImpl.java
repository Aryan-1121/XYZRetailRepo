package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xyzretail.bean.Item;

public class BasketDaoImpl implements BasketDao{

	
	@Override
	public int addItem(Item item) {
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileyc256", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO BASKET values(?,?,?,?,?,?)");) {
			
			

			preparedStatement.setString(1, item.getItemId());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setDouble(3, item.getItemPrice());
			preparedStatement.setDouble(4, item.getItemTax());
			preparedStatement.setInt(5, item.getItemLeft());
			preparedStatement.setInt(6, item.getItemSold());

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}


	

	@Override
	public boolean updateRecord(String itemID) {
		
//		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileyc256", "root",
//				"wiley"); 
//				Statement statement = connection.createStatement();) {
//			
//			
//			
//			
//			
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return false;
	}

	
	
	
	@Override
	public List<Item> getAllItems() {
		
		List<Item> itemList = new ArrayList<Item>();
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileyc256", "root",
				"wiley"); 
				Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM BASKET");

			while (resultSet.next()) {
     			String itemId = resultSet.getString("item_Id");
				String itemName = resultSet.getString("Item_Name");
				double item_Price = resultSet.getDouble("Item_Price");
				double item_Tax=resultSet.getDouble("Item_Tax");
				int item_Quantity_left= resultSet.getInt("quantity_Left");
				int item_Quantity_sold= resultSet.getInt("quantity_Sold");
				

				itemList.add(new Item(itemId,itemName,item_Price,item_Tax,item_Quantity_left,item_Quantity_sold));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemList;
	}


	@Override
	public Item searchItemById(String item_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
