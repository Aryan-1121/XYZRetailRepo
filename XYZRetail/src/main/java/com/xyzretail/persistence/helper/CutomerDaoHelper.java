package com.xyzretail.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xyzretail.bean.Customer;

public class CutomerDaoHelper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		String UserName = resultSet.getString("User_Name");
		String UserPassword = resultSet.getString("User_Password");
		
		Customer cutomer=new Customer(UserName,UserPassword);
		return cutomer;
	}

}
