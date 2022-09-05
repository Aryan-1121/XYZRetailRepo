package com.xyzretail.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemDetail;
@Repository
public interface Item_DetailDao extends JpaRepository<ItemDetail, String>{	
	
//	@Modifying
//	@Transactional
//	@Query(value = "insert into Customer (user_Name, user_Password) values(?,?)", nativeQuery = true)
//	int registerCustomer(String user_Name, String user_Password);

//	ItemDetail findByItemId(String itemId);
	
	ItemDetail findByItem_IdAndAvailable_Quantity (String itemId,int availableQuantity);
}







