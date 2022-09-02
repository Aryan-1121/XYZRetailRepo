package com.xyzretail.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemsCartList;
import com.xyzretail.service.ItemsCartService;

@RestController
public class CartResource {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ItemsCartService itemsCartService;
	
	@GetMapping(path="carts/all",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemsCartList getAllItemsInCart() {
		return itemsCartService.getItemsInCart(null);
	}
	

}
