
package com.xyzretail.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Customer;
import com.xyzretail.persistence.util.CustomerRowMapper;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	
	
	
	@Override
	public boolean addCustomer(Customer customer) {	
		int rows = 0;
		String query ="INSERT INTO customer values(?,?)";
			try {	
			rows = jdbcTemplate.update(query,customer.getUserName(), customer.getUserPassword());
		} catch (Exception e) {
			System.out.println("This UserName is already taken, try for another one :)");
		}	
		if(rows!=0)
			return true;
		return false;
	}
	
	
	
	
	
	

	@Override
	public Customer validateCustomer(Customer customer) {
		Customer cus=null;
		try {
		String sql = "SELECT * FROM CUSTOMER WHERE USER_NAME = ?";
		 cus = jdbcTemplate.queryForObject(sql, new CustomerRowMapper(),customer.getUserName());
		} 
		catch (Exception e) {
			System.out.println("UserName and Password Missmatch !!");
		}
		return cus;
	}
}
