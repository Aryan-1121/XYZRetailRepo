package com.xyzretail.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;

@Repository
public interface ItemsCartDao extends JpaRepository<ItemsCart, Integer> {

	
	@Query("from ItemsCart where user_name=:userName")
	public ItemsCartList findByUserName(@Param("userName") String userName);
}
