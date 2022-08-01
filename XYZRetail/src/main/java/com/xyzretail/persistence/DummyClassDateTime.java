package com.xyzretail.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.xyzretail.bean.DateTime;


public class DummyClassDateTime {
	
	private boolean connectDB() {			
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				Statement  statement=connection.createStatement();) {
			String sql="create table if not exists DummyTime"
					+ "Purchase_Time Timestamp not null ,"
					+ "Purchase_Date date not null"
					+ ");";
			
			statement.executeUpdate(sql);
			return true;
			}
		catch(SQLException e) {
			return false;}
		}

	public boolean addDateTime() {
		DateTime datetime=new DateTime();
		int rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO DummyTime VALUES (?,?)");) {
		
//			java.util.Date date=new java.util.Date();
//			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//			java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());

			preparedStatement.setTimestamp(1, datetime.getTime());
			preparedStatement.setDate(2, datetime.getDate());
			
			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
		}

		if(rows!=0)
			return true;


		return false;
	}
	
	public List<DateTime> showDateTime() {
	
		List<DateTime> dt=new ArrayList<DateTime>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ShoppingBasket", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM DummyTime");) {
			
//			java.util.Date date=new java.util.Date();
//			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
//			java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
			
		
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
			Timestamp purchasedtime = resultSet.getTimestamp("Purchase_Time");
			Date purchaseddate=resultSet.getDate("Purchase_Date");
			
				dt.add(new DateTime(purchasedtime,purchaseddate));
			}
			
			
			}
		
			
	catch (SQLException e) {
		System.out.println();
	}
	
	return dt;

}
	
}
