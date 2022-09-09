package com.xyzretail.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xyzretail.bean.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, String>{	
	
	@Modifying
	@Transactional
	@Query(value = "insert into Customer (userName, userPassword) values(?,?)", nativeQuery = true)
	int registerCustomer(String user_Name, String user_Password);
	
}








