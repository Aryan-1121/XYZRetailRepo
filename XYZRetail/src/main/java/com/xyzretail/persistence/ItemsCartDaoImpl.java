package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xyzretail.bean.*;

public class ItemsCartDaoImpl implements ItemsCartDao {
	PersistenceDao persistenceDao=new PersistenceDaoImpl();
		
	private boolean connectDB() {			
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				Statement  statement=connection.createStatement();) {
			String sql="Create table if not exists "
					+ "ItemsCart(itemId varchar(10),"		//	string -> varchar
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
	public boolean addItemToCart(ItemDetails item,String customer, int reqQuantity, double tax, double totalCost ) {
		int rows=0;
		if(connectDB()) {
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement=connection.prepareStatement("Insert into ItemsCart values(?,?,?,?,?);")){
			preparedStatement.setString(1,item.getItemId());
			preparedStatement.setString(2, customer);
			preparedStatement.setInt(3, reqQuantity);
			preparedStatement.setDouble(4, tax);
			preparedStatement.setDouble(5,totalCost);
			
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
	public void deleteItemFromCart(String customer) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				PreparedStatement statement = connection.prepareStatement("delete FROM ItemsCart where User_Name=?");) {

			statement.setString(1, customer);
			statement.executeUpdate();
			}catch(SQLException e) {
				System.out.println("exception occured in deleting from cart :");
				System.out.println(e);
				
			}
		
		
	}

	@Override
	public List<ItemsCart> getAllItemsInCart(String customer) {
		List<ItemsCart> cart=new ArrayList<ItemsCart>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM ItemsCart where User_Name=?");) {

			statement.setString(1, customer);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				String itemId=resultSet.getString("ItemId");
				String userName = resultSet.getString("User_Name");
				int reqQuantity=resultSet.getInt("requiredQuantity");
				double tax=resultSet.getDouble("Tax");
				double cost=resultSet.getDouble("totalCost");
		
				cart.add(new ItemsCart(persistenceDao.searchItemsById(itemId),userName,reqQuantity,tax,cost));
				}
			}catch(SQLException e) {
				System.out.println("No item in cart or cart doesnot exist!!");
			}
		return cart;
	}

	@Override
	public int unselectFromCart(String itemId, String customer) {
		int rows=0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				Statement state=connection.createStatement();
				PreparedStatement statement = connection.prepareStatement("delete FROM ItemsCart where User_Name=? and itemId = ?");) {

			state.execute("set sql_safe_updates=0;");
			statement.setString(1, customer);
			statement.setString(2, itemId);
			rows=statement.executeUpdate();
			}catch(SQLException e) {
				System.out.println("exception occured in removing item from cart :");
				System.out.println(e);
				
			}
		return rows;
	}

	@Override
	public boolean modifyQuantityOfCartItems(String customer, String itemId, int modifiedQuantity,double tax, double cost ) {
		int rows=0;
		System.out.println(rows);
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley"); 
				PreparedStatement statement = connection.prepareStatement("update itemsCart set requiredQuantity= ?, tax=?, totalCost=? where ItemId = ? and User_name =?;");) {
					
			statement.setInt(1, modifiedQuantity);
			statement.setDouble(2, tax);
			statement.setDouble(3, cost);
			statement.setString(4, itemId);
			statement.setString(5, customer);
			rows=statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("exception occured in modifying the required Quantity :");
			System.out.println("Requested qunatity is not available!!");
		}
		
		if(rows!=0) {
			return true;
		}
		else {
			
			System.out.println(rows);
			return false;
		}
		
	}

	@Override
	public boolean searchItemById(String itemId,String customer) {
		List<ItemsCart> cart=getAllItemsInCart(customer);
		for(ItemsCart item:cart) {
			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
				return true;
//			System.out.println(item.getCustomer()+"  "+item.getItem().getItemId() );
		}
		System.out.println("you dont have "+itemId+" in your cart");
		return false;
	}

}


















