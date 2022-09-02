package com.xyzretail.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.helper.ItemsCartDaoHelper;

@Repository("itemsCartDao")
public class ItemsCartDaoImpl implements ItemsCartDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Autowired
	private PersistenceDao persistenceDao;
	

	@Override
	public int addItemToCart(ItemDetails item,String customer, int reqQuantity, double tax, double totalCost ) {
		int rows=0;
		String query = "Insert into ItemsCart values(?,?,?,?,?)";			
			rows=jdbcTemplate.update(query, item.getItemId(), customer, reqQuantity, tax,  totalCost  );
		return rows;
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
//		String sql="SELECT * FROM ItemsCart where User_Name= ?";
//		List<ItemsCart> cart=jdbcTemplate.query(sql, new ItemsCartDaoHelper(), customer);
//		return cart;
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
		String sql="delete FROM ItemsCart where User_Name=? and itemId = ?";
		int rows=jdbcTemplate.update(sql, customer,itemId);
		return rows;
	}

	@Override
	public int modifyQuantityOfCartItems(String customer, String itemId, int modifiedQuantity,double tax, double cost ) {
		String sql="update itemsCart set requiredQuantity= ?, tax=?, totalCost=? where ItemId = ? and User_name =?";
		int rows=jdbcTemplate.update(sql,modifiedQuantity,tax,cost,itemId,customer);
		return rows;	
	}

	@Override
	public boolean searchItemById(String itemId,String customer) {
		String sql="select * from itemsCart where User_Name=? and itemId=?";

		List<ItemsCart >cart=jdbcTemplate.query(sql, new ItemsCartDaoHelper(),customer, itemId);
		if(cart!=null) {
			return true;
		}

		return false;
	}
	
	public ItemsCart getItemById(String itemId,String customer) {
//		String sql="select * from itemsCart where User_Name=  \""+customer+"\"    and itemId= \""+itemId+"\"";
//		String sql="select * from itemsCart where User_Name= ?   and itemId= ?";
//		List<ItemsCart> cart=jdbcTemplate.query(sql, new ItemsCartDaoHelper(),customer,itemId);
//		System.out.println("itemsCart :"+cart);
//		return cart.get(0);
		
		List<ItemsCart> cart=getAllItemsInCart(customer);
		for(ItemsCart item:cart) {
			if(item.getItem().getItemId().equalsIgnoreCase(itemId))
				return item;
//			System.out.println(item.getCustomer()+"  "+item.getItem().getItemId() );
		}
//		System.out.println("you dont have "+itemId+" in your cart");
		return null;
	}

}