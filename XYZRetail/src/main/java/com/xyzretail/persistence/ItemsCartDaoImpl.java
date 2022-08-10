package com.xyzretail.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.*;
import com.xyzretail.persistence.helper.ItemsCartDaoHelper;

@Repository("itemsCartDao")
public class ItemsCartDaoImpl implements ItemsCartDao {


	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	@Override
	public int addItemToCart(ItemDetails item,String customer, int reqQuantity, double tax, double totalCost ) {
		
		String sql="Insert into ItemsCart values(?,?,?,?,?)";
		int rows=jdbcTemplate.update(sql, item.getItemId(),customer,reqQuantity,tax,totalCost);
		return rows;
			
	}

	@Override
	public int deleteItemFromCart(String customer) {
		String sql="delete FROM ItemsCart where User_Name=?";
		int rows=jdbcTemplate.update(sql, customer);
		return rows;	
	}

	@Override
	public List<ItemsCart> getAllItemsInCart(String customer) {
		String sql="SELECT * FROM ItemsCart where User_Name= \""+customer+"\"";
		List<ItemsCart> cart=jdbcTemplate.query(sql, new ItemsCartDaoHelper());
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
//		String sql="select * from itemsCart where User_Name=? and itemId=?";
		String sql="select * from itemsCart where User_Name= \""+customer+"\"    and itemId= \""+itemId+"\""  ;

		ItemsCart cart=(ItemsCart) jdbcTemplate.query(sql, new ItemsCartDaoHelper());
		if(cart!=null) {
			return true;
		}
		return false;
	}
	
	public ItemsCart getItemById(String itemId,String customer) {
		String sql="select * from itemsCart where User_Name=  \""+customer+"\"    and itemId= \""+itemId+"\"";
		ItemsCart cart=(ItemsCart) jdbcTemplate.query(sql, new ItemsCartDaoHelper());
		return cart;
	}

}


















