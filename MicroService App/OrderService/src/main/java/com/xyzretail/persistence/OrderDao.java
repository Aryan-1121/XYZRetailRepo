package com.xyzretail.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {

}
