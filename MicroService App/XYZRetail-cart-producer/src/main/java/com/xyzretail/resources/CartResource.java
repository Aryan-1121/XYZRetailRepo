package com.xyzretail.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;
import com.xyzretail.persistence.ItemsCartDao;
import com.xyzretail.service.ItemsCartService;

@RestController
public class CartResource {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ItemsCartService itemsCartService;
	
	@Autowired
	private ItemsCartDao itemsCartDao;
	
	@GetMapping(path="/cart/all",produces=MediaType.APPLICATION_JSON_VALUE)
	public /*List<ItemsCart>*/ItemsCartList getAllItemsInCart() {
//		List<ItemsCart> cart=itemsCartDao.findByUserName("lakshmi");
//		return cart;
		return itemsCartService.getItemsInCart(new Customer("lakshmi","wiley"));
	}
	

}
