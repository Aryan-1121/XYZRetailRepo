
package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xyzretail.bean.Customer;

public class CustomerDaoImpl implements CustomerDao {

	
	

	@Override
	public boolean addCustomer(Customer customer) {
		
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO customer values(?,?)");) {
		
			preparedStatement.setString(1, customer.getUserName() );
			preparedStatement.setString(2, customer.getUserPassword());
			
			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("This UserName is already taken, try for another one :)");
		}

		if(rows!=0)
			return true;


		return false;
	}
	

	@Override
	public boolean validateCustomer(Customer customer) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM CUSTOMER WHERE USER_NAME = ?");) {
			
			preparedStatement.setString(1, customer.getUserName() );
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next(); 	
			String UserName = resultSet.getString("User_Name");
			String UserPassword = resultSet.getString("User_Password");
	
			System.out.println("---------------------------------------");
			if(UserName.equals(null))	 {
				System.out.println("incorrect usernameS");
				return false;
			}
			
			
			
			if(UserName.equals(customer.getUserName())) {
				
				if(UserPassword.equals(customer.getUserPassword())) {
					return true;
				}
				else
					System.out.println("Check your Password and Try again :) ");
				}
			
			else {
					
				System.out.println("Check your User Name and Try again :) ");
				return false;
			}
			
			

		} catch (SQLException e) {
			System.out.println("Enter correct userName");
		}

		return false;
	}
}
