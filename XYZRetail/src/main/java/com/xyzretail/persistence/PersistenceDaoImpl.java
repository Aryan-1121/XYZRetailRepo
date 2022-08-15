package com.xyzretail.persistence;

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
	public ItemDetails searchItemsById(String id) {

		String query ="SELECt * from Item_Details where Item_Id= ?";
//			jdbcTemplate.update(query, id);
			ItemDetails item =jdbcTemplate.queryForObject(query, new BasketDaoHelper(), id);

		return item;
	}

}
