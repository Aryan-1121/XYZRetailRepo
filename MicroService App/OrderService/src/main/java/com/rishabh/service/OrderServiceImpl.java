package com.rishabh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rishabh.bean.Orders;
import com.rishabh.persistence.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public Orders saveOrder(Orders order) {
		
		return orderDao.save(order);
	
	}

}
