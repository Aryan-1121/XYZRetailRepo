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
	@Query(value="update ItemsCart set requiredQuantity=:q, totalCost=:cost where itemId =:id and userName =:name",nativeQuery = true)
	public int updateByItemId(@Param("q") int requiredQuantity,@Param("cost") double totalCost,@Param("id") String itemId,@Param("name") String userName);


	@Modifying
	@Transactional
	@Query(value="insert into ItemsCart (itemId,itemName,unitPrice,userName,requiredQuantity,salesTax,totalCost) values(:id,:name,:price,:uName,:q,:tax,:cost)",nativeQuery=true)
	public int addItemToCart(@Param("id") String itemId,@Param("name") String itemName,@Param("price")double unitPrice,@Param("uName")String userName,@Param("q")int requiredQuantity,@Param("tax") double salesTax,@Param("cost")double totalCost);


	@Modifying
	@Transactional
	@Query(value="delete from itemscart where userName=:customer",nativeQuery=true)
	public int deleteAllByUserName(@Param("customer")String customer);
	
}

