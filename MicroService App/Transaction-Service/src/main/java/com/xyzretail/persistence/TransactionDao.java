package com.xyzretail.persistence;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	
	@Modifying
	@Transactional
	@Query(value="insert into transaction (date, time, userName) values(date(now()) , time(now()),:userName);" ,nativeQuery = true )
	int saveTransactionByUserName (@Param("userName") String userName);
		
	
}
