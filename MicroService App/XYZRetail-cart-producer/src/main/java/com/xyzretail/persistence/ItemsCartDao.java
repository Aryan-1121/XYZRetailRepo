package com.xyzretail.persistence;

import java.util.List;

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
	@Query("from ItemsCart where userName=:username")
	public List<ItemsCart> findByUserName(@Param("username") String userName);
}
