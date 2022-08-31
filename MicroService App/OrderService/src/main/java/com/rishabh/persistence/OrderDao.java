package com.rishabh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishabh.bean.Orders;

@Repository
public interface OrderDao extends JpaRepository<Orders, Integer> {

}
