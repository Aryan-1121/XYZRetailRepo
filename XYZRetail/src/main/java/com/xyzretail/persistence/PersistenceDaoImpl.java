package com.xyzretail.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.helper.BasketDaoHelper;

@Repository("persistenceDao")
public class PersistenceDaoImpl implements PersistenceDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean updateQuantity(int purchasedQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemDetails searchItemsById(String id) {
		String query ="SELECT * FROM Item_Details where Item_Id= ?";
			jdbcTemplate.update(query, id);
			
			ItemDetails item = (ItemDetails) jdbcTemplate.query(query, new BasketDaoHelper());
		return item;
	}

	@Override
	public List<ItemDetails> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchItemsById(String id, int reqQuantity) {
		

		ItemDetails item=searchItemsById(id);


		if(item.getAvailableQuantity()>reqQuantity) {
			return true;
		}
		System.out.println("We don't have that much quantity in our store :(");

		return false;
	}

}
