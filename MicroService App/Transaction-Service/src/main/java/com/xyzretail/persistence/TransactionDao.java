package com.xyzretail.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.Transaction;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, Integer>{

}
