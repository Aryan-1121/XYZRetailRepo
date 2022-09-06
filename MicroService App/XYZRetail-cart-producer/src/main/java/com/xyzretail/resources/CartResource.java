package com.xyzretail.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@Autowired
//	private ItemsCartDao itemsCartDao;
	
	@GetMapping(path="/cart/all/{customer}",produces=MediaType.APPLICATION_JSON_VALUE)
	public /*List<ItemsCart>*/ItemsCartList getAllItemsInCart(@PathVariable("customer")String name) {
//		List<ItemsCart> cart=itemsCartDao.findByUserName("lakshmi");
//		return cart;
		return itemsCartService.getItemsInCart(name);
	}
	
	@DeleteMapping(path="/cart/delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemsCart deleteItemInCart(@PathVariable("id") String itemId) {
		return itemsCartService.deleteItemByItemId(new Customer("lakshmi","wiley"), itemId);
	}
	
	//@PostMapping(path="cart/")
	
}
