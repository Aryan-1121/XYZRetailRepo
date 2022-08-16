	package com.xyzretail.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	
	
	
	
	
	
	@Override
	public boolean performTransaction(String customer) {

		int rows = 0;
		try{
			String query= "INSERT INTO transactionTable (User_Name, transaction_date, transaction_time) values(?,current_date(), current_Time())";
			rows= jdbcTemplate.update(query,customer);
		} catch (Exception e) {
			System.out.println("Transaction couldn't complete");
			System.out.println("exception occured \n"+ e);
		}
		if(rows!=0)
			return true;
		return false;
	}

	
	
	
	
	
	
	
	

	@Override
	public void insertIntoOrderTable(String customer) {
		int rows = 0;
		try {		
		String query1 ="select max(transactionId ) as maxid from transactionTable;";
		String query2="insert ignore into orders select t.transactionId , i.itemId, requiredQuantity from itemsCart i, transactionTable t where (transactionId=? )and t.User_Name=i.User_Name;";		
		Integer transacId =jdbcTemplate.queryForObject(query1,Integer.class);
		rows = jdbcTemplate.update(query2,transacId);
		}
		catch(Exception e) {
			System.out.println("ecpetion occured : "+ e);
		}
		if(rows!=0)
			System.out.println();
		else 
			System.out.println("couldn't update your Order table  !!");
		}


	
	
	
	
	
	
	
	
	@Override
	public int monthCount(String customer) {
		int month =0;
		try {			
			String query ="select count(*) as monthCount from transactionTable where user_Name=? and month(now())=month(transaction_Date) and year(now())=year(transaction_Date)"; 		
			month= jdbcTemplate.queryForObject(query,Integer.class, customer);
		} catch (Exception e) {
			System.out.println(" couldn't insert into orders Table");
			System.out.println("exception occured \n"+ e);		
		}
		return month;
	}

	
	
}
