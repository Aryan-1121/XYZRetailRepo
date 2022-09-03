package com.xyzretail.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemDetailsList;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;
import com.xyzretail.persistence.ItemsCartDao;

@Service
public class ItemsCartServiceImpl implements ItemsCartService {
	
	@Autowired
	private ItemsCartDao itemsCartDao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//private ItemsCartList cartList;

	@Override
	public ItemsCartList getItemsInCart(Customer customer) {
		List<ItemsCart> cart=itemsCartDao.findByUserName(customer.getUser_Name());
		ItemsCartList cartList=new ItemsCartList(cart);
		return cartList;
	}


}
