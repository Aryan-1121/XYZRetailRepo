package com.xyzretail.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer> {

	@Query(value = "select max(transactionId) from Transaction", nativeQuery = true)
	int getMaxTransactionId();
	
	
	@Query(value = "from Transaction where userName=:user")
	List<Transaction> getTransactionByUserName(@Param("user") String userName);
		
	
}
