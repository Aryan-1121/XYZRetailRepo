package com.rishabh.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.bean.Orders;
import com.rishabh.service.OrderService;

@RestController
public class OrderResource {

	@Autowired
	private OrderService orderService;
	
	@PostMapping(path="/orders",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Orders getOrderResource(@RequestBody Orders order){
		return orderService.saveOrder(order); 
	}
}
