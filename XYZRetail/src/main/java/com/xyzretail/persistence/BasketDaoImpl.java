package com.xyzretail.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.helper.BasketDaoHelper;

@Repository("basketDao")
public class BasketDaoImpl implements BasketDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int updateRecord(String itemID , int quantity) {
		
	String sql=	"update item_Details set Available_Quantity=  Available_Quantity - ? where Item_Id = ? ";
	int rows=jdbcTemplate.update(sql,quantity,itemID);
	return rows;

	}
	
	@Override
	public List<ItemDetails> getAllItems() {
		String sql="SELECT * FROM Item_Details";
		List<ItemDetails> itemList=jdbcTemplate.query(sql, new BasketDaoHelper());
		return itemList;
	}

}
