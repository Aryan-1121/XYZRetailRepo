package com.xyzretail.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xyzretail.bean.Customer;

public class CustomerDaoHelper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		String UserName = resultSet.getString("User_Name");
		String UserPassword = resultSet.getString("User_Password");
		
		Customer customer=new Customer(UserName,UserPassword);
		return customer;
	}

}
