package com.xyzretail.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.util.ItemsRowMapper;


@Repository("basketDao")
public class BasketDaoImpl implements BasketDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	
	
	
	@Override
	public int addItem(ItemDetails item) {
		int rows = 0;
		String query ="INSERT INTO BASKET values(?,?,?,?,?,?)";
			rows = jdbcTemplate.update(query, item.getItemId(),item.getItemCategory(), item.getItemName() , item.getItemPrice(), item.getAvailableQuantity());
		return rows;
	}


	
	
	
	
	
	@Override
	public void updateRecord(String itemID , int quantity) {
		String query ="update item_Details set Available_Quantity=  Available_Quantity - ? where Item_Id = ? ";
			jdbcTemplate.update(query,quantity,itemID);
	}

	
	
	
	
	
	
	@Override
	public List<ItemDetails> getAllItems() {
	List<ItemDetails> itemList = new ArrayList<ItemDetails>();
		String query = "SELECT * FROM Item_Details";
		itemList = jdbcTemplate.query(query,new ItemsRowMapper());	
		return itemList;
	}


}
