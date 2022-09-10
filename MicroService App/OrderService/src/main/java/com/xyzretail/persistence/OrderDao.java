package com.xyzretail.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {

	
	@Modifying
	@Transactional
	@Query(value = "insert into orders (")
	void saveOrder();
}
