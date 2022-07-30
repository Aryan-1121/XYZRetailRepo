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
import com.xyzretail.bean.ItemsCart;

public class ItemsCartDaoImpl implements ItemsCartDao {
	PersistenceDao persistenceDao=new PersistenceDaoImpl();
	
	private boolean connectDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				Statement  statement=connection.createStatement();) {
			String sql="Create table if not exists "
					+ "ItemsCart(itemId String,"
					+ "requiredQuantity int not NULL,"
					+ "tax double,"
					+ "totalCost double,"
					+ "constraint itemFK foreign key(itemId) references Item_Details(Item_Id)); ";
			statement.executeUpdate(sql);
			return true;
			}
		catch(SQLException e) {
			return false;}
		}

	@Override
	public boolean addItemToCart(ItemDetails item, int reqQuantity, double tax, double totalCost) {
		int rows=0;
		if(connectDB()) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement=connection.prepareStatement("Insert into ItemsCart values(?,?,?,?);")){
			preparedStatement.setString(1,item.getItemId());
			preparedStatement.setInt(2, reqQuantity);
			preparedStatement.setDouble(3, tax);
			preparedStatement.setDouble(4,totalCost);
			rows=preparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println("Unable to add item!!");
		}
		if(rows!=0) {
			return true;
		}
		}
		return false;
	}

	@Override
	public boolean deleteItemFromCart(String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ItemsCart> getAllItemsInCart() {
		List<ItemsCart> cart=new ArrayList<ItemsCart>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM ItemsCart");
			while(resultSet.next()) {
				String itemId=resultSet.getString("ItemId");
				int reqQuantity=resultSet.getInt("requiredQuantity");
				double tax=resultSet.getDouble("Tax");
				double cost=resultSet.getDouble("totalCost");
		
				cart.add(new ItemsCart(persistenceDao.searchItemsById(itemId),reqQuantity,tax,cost));
				}
			}catch(SQLException e) {
				System.out.println("No item in cart or cart doesnot exist!!");
			}
		return cart;
	}

}
