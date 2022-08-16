package com.xyzretail.persistence;

public interface TransactionDao {

		
		boolean performTransaction(String customer);
		
		public void insertIntoOrderTable(String customer);
			
		public int monthCount(String customer);
}
