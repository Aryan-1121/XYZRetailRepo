package com.xyzretail.persistence;

import java.sql.Time;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction,Integer> {
	
	@Modifying
	@Transactional
	@Query(value="INSERT into Transaction (transactionId,customerName,itemId,itemCategory,itemName,itemPrice,availableQuantity,purchaseQuantity,salesTax,totalCost,date,time) values(:tId,:cName,:iId,:cat,:iName,:iPrice,:aQuan,:pQuan,:tax,:cost,:d,:t)",nativeQuery=true)
	int saveTransaction(@Param("tId") int transactionId,@Param("cName") String customerName,@Param("iId") String itemId,
			@Param("cat") String itemCategory,@Param("iName") String itemName,@Param("iPrice") double itemPrice,@Param("aQuan") int availableQuantity,
			@Param("pQuan") int purchaseQuantity,@Param("tax") double salesTax, @Param("cost")double totalCost,
			@Param("d") Date date, @Param("t") Time time);
	

	
	
	
	
}
