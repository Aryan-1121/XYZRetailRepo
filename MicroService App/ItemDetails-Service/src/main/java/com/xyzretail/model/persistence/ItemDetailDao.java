package com.xyzretail.model.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetail;
@Repository
public interface ItemDetailDao extends JpaRepository<ItemDetail, String>{	
	
//	@Modifying
//	@Transactional
//	@Query(value = "insert into Customer (user_Name, user_Password) values(?,?)", nativeQuery = true)
//	int registerCustomer(String user_Name, String user_Password);

//	ItemDetail findByItemId(String itemId);
	
	@Query(value="from ItemDetail where itemId=:itemId and availableQuantity=:availableQuantity")
	ItemDetail findByItemIdAndAvailableQuantity(@Param("itemId")String itemId,@Param("availableQuantity")int availableQuantity);
}







