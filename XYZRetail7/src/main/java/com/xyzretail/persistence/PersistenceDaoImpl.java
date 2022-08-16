package com.xyzretail.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.util.ItemsRowMapper;

@Repository("persistenceDao")
public class PersistenceDaoImpl implements PersistenceDao {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	
	
	@Override
	public ItemDetails searchItemsById(String id) {
		ItemDetails item=null;
		try{
			String query= "SELECT * FROM Item_Details where Item_Id= ?";	
			item=jdbcTemplate.queryForObject(query, new ItemsRowMapper(),id);		
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return item;
	}



}
