package com.xyzretail.persistence;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
	@Query("from ItemDetail where itemId=:itemId and availableQuantity>=:availableQuantity")
	ItemDetail findByItemIdAndAvailableQuantity(@Param("itemId")String itemId,@Param("availableQuantity")int availableQuantity);
	
	
	@Modifying
	@Transactional
	@Query(value="update itemDetail set availableQuantity=:quantity where itemId=:itemId",nativeQuery = true)
	int updateRecord(@Param("quantity") int  quantity,@Param("itemId") String itemID );
}







