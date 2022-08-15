package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.*;
import com.xyzretail.persistence.util.ItemsCartRowMapper;

@Repository("itemsCartDao")
public class ItemsCartDaoImpl implements ItemsCartDao {
	private PersistenceDao persistenceDao;
	
	@Autowired	
	public void setPersistenceDao(PersistenceDao persistenceDao) {
		this.persistenceDao = persistenceDao;
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	
	
	@Override
	public boolean addItemToCart(ItemDetails item,String customer, int reqQuantity, double tax, double totalCost ) {
		int rows=0;

		String query = "Insert into ItemsCart values(?,?,?,?,?)";			
			rows=jdbcTemplate.update(query, item.getItemId(), customer, reqQuantity, tax,  totalCost  );
		if(rows!=0) {
			return true;
		}
		
		return false;
	}

	
	
	
	
	
	@Override
	public void deleteItemFromCart(String customer) {
		
		try {
			String query ="delete FROM ItemsCart where User_Name=?";			
			jdbcTemplate.update(query, customer);
			}
		catch(Exception e) {
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
		
//		List<ItemsCart> cart=new ArrayList<ItemsCart>();
//		try  {
//			String query ="SELECT * FROM ItemsCart where User_Name= ?";
//			
//			cart =jdbcTemplate.query(query, new ItemsCartRowMapper(), customer);
//			
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//		return cart;
	}

	
	
	
	
	
	
	@Override
	public int unselectFromCart(String itemId, String customer) {
		int rows=0;
		try{
			String query ="delete FROM ItemsCart where User_Name=? and itemId = ?";
			rows =jdbcTemplate.update(query, customer,itemId);
			}catch(Exception e) {
				System.out.println("exception occured in removing item from cart :");
				System.out.println(e);
				
			}
		return rows;
	}

	
	
	
	
	
	@Override
	public boolean modifyQuantityOfCartItems(String customer, String itemId, int modifiedQuantity,double tax, double cost ) {
		int rows=0;
		try{
			String query="update itemsCart set requiredQuantity= ?, tax=?, totalCost=? where ItemId = ? and User_name =?";
			rows=jdbcTemplate.update(query, modifiedQuantity, tax, cost, itemId, customer);
		}
		catch(Exception e) {
			System.out.println("exception occured in modifying the required Quantity :");
			System.out.println("Requested qunatity is not available!!");
		}
		if(rows!=0) 
			return true;
		else 
			return false;
		
		
	}

	@Override
	public boolean searchItemById(String itemId,String customer) {
		List<ItemsCart> cart=getAllItemsInCart(customer);
		for(ItemsCart item:cart) {
			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
				return true;
		}
		//System.out.println("you dont have "+itemId+" in your cart");
		return false;
	}
	
	public ItemsCart getItemById(String itemId,String customer) {
		List<ItemsCart> cart=getAllItemsInCart(customer);
		for(ItemsCart item:cart) {
			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
				return item;
		}
		//System.out.println("you dont have "+itemId+" in your cart");
		return null;
	}

}


















