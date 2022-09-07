package com.xyzretail.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@Autowired
	private ItemsCartDao itemsCartDao;
	
	@GetMapping(path="/cart/all/{customer}",produces=MediaType.APPLICATION_JSON_VALUE)
	public /*List<ItemsCart>*/ItemsCartList getAllItemsInCart(@PathVariable("customer")String name) {
//		List<ItemsCart> cart=itemsCartDao.findByUserName("lakshmi");
//		return cart;
		return itemsCartService.getItemsInCart(name);
	}
	
	@DeleteMapping(path="/cart/delete/{id}/{customer}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemsCart deleteItemInCart(@PathVariable("id") String itemId,@PathVariable("customer") String name) {
		return itemsCartService.deleteItemByItemId(name, itemId);
	}
	
	@PutMapping(path="cart/update/{id}/{reqQuantity}/{customer}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemsCart updateItemInCart(@PathVariable("id") String itemId,@PathVariable("reqQuantity")int quantity,@PathVariable("customer") String name) {
		return itemsCartService.updateByItemId(name, itemId, quantity);
	}
	
<<<<<<< HEAD
	@GetMapping(path="/cart/all/{itemId}/{userName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<ItemsCart> getbyIdAndUserName(@PathVariable("itemId")String itemId, @PathVariable("userName") String userName) {
//		Optional<ItemsCart> ic =itemsCartDao.findByItemIdAndUserName(itemId, userName);
//		System.out.println("this isi find by item id and username :"+ic);
//		return ic;
		return itemsCartDao.findByItemIdAndUserName(itemId, userName);
=======
	@PostMapping(path="cart/add/{id}/{reqQuantity}/{customer}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ItemsCart addItemInCart(@PathVariable("id") String itemId,@PathVariable("reqQuantity")int quantity,@PathVariable("customer") String name) {
		return itemsCartService.addItemtoCart(name, itemId, quantity);
>>>>>>> branch 'master' of https://github.com/Nagalakshmi-S/XYZRetailRepo.git
	}
	
}
