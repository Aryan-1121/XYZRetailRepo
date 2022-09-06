package com.xyzretail.persistence;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemsCart;

@Repository
public interface ItemsCartDao extends JpaRepository<ItemsCart, Integer> {

	@Modifying
	@Transactional
	@Query("Delete from ItemsCart where itemId=:id and userName=:name")
	public int deleteItemByItemId(@Param("id") String itemId,@Param("name") String customer); 
	

	@Query("from ItemsCart where itemId=:id and userName=:name")
	public Optional<ItemsCart> findByItemIdAndUserName(@Param("id") String itemId,@Param("name") String userName);
	

	@Query("from ItemsCart where userName=:username")
	public List<ItemsCart> findByUserName(@Param("username") String userName);
	

	@Modifying
	@Transactional
	@Query(value="update itemsCart set requiredQuantity=:q, totalCost=:cost where itemId =:id and userName =:name",nativeQuery = true)
	public int updateByItemId(@Param("q") int requiredQuantity,@Param("cost") double totalCost,@Param("id") String itemId,@Param("name") String userName);

}
