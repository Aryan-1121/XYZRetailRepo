package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.Transaction;

public class TransactionDaoImpl implements TransactionDao{
	
	
	@Override
	public Transaction getTransactionDetails(Customer customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean performTransaction(String customer) {

		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO transactionTable (User_Name, transaction_date, transaction_time)"
								+ "values(?,current_date(), current_Time())");) {
			
			preparedStatement.setString(1,customer);
			
			
			rows = preparedStatement.executeUpdate();			

		} catch (SQLException e) {
			System.out.println("Transaction couldn't complete");
			System.out.println("exception occured \n"+ e);
		}

		if(rows!=0)
			return true;
		

		return false;
	}

	@Override
	public boolean updateTransaction(Customer customerName, String itemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insertIntoOrderTable(String customer) {

		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement statement = connection
						.prepareStatement("select max(transactionId ) as maxid from transactionTable;");
				PreparedStatement preparedStatement = connection
						.prepareStatement("\r\n" + 
								"insert ignore into orders \r\n" + 
								"select t.transactionId , i.itemId, requiredQuantity\r\n" + 
								"from itemsCart i, transactionTable t\r\n" + 
								"where (transactionId=? )and t.User_Name=i.User_Name;"
								); ) {
			
			
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			int transacId= resultSet.getInt("maxid");		
			preparedStatement.setInt(1,transacId);
			
			
			rows = preparedStatement.executeUpdate();			

		} catch (SQLException e) {
			System.out.println(" couldn't insert into orders Table");
			System.out.println("exception occured \n"+ e);
		}

		if(rows!=0)
			System.out.println();
		else 
			System.out.println("coulden't update your Order table  !!");
		
		
		
	}

}
