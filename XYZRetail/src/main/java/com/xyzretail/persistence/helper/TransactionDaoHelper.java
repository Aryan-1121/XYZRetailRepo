package com.xyzretail.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xyzretail.bean.Transaction;

//public class TransactionDaoHelper implements RowMapper<Transaction> {
//
//	@Override
//	public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//			int month= rs.getInt("monthCount");	
//			int transactionId= re.getInt("transactionId");
//			Transaction transaction = new Transaction(month);
//		return month;
//	}
//
//}
