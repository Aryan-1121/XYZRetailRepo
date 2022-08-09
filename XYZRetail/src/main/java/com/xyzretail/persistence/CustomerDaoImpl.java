
package com.xyzretail.persistence;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Customer;
import com.xyzretail.persistence.helper.CutomerDaoHelper;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addCustomer(Customer customer) {
		
		String sql="INSERT INTO customer values(?,?)"; 
		int rows=jdbcTemplate.update(sql, customer.getUserName(),customer.getUserPassword());
		
		return rows;
	}
	

	@Override
	public Customer validateCustomer(Customer customer) {
		
		String sql="SELECT * FROM CUSTOMER WHERE USER_NAME = ?";
		Customer cus=(Customer) jdbcTemplate.query(sql,new CutomerDaoHelper());
		
		return cus;
	}
	
}
