package com.xyzretail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	
	private double getTax(String itemCategory) {
		int tax;
		switch(itemCategory) {
		case "Books":
		
			tax=0;
			break;
		case "CD"  :
		
			tax=10;
			break;
		case "COSMETICS":
		
			tax=12;
			break;
		default:
			tax=0;
			break;
		}
		return tax;
	}

	@Override
	public ItemsCartList getItemsInCart(Customer customer) {
		List<ItemsCart> cart=itemsCartDao.findByUserName(customer.getUser_Name());
		ItemsCartList cartList=new ItemsCartList(cart);
		return cartList;
	}

	@Override
	public ItemsCart deleteItemByItemId(Customer customer, String itemId) {
		
		Optional<ItemsCart> itemOpt=itemsCartDao.findByItemIdAndUserName(itemId, customer.getUser_Name());
		
		if(itemOpt.isPresent()) {
			itemsCartDao.deleteItemByItemId(itemId, customer.getUser_Name());
			return itemOpt.get();
		}
		return new ItemsCart();
		
	}

	@Override
	public ItemsCart updateByItemId(Customer customer, String itemId, int requiredQuantity) {
	
		Optional<ItemsCart> it=searchByItemIdAndName(customer, itemId);
		
		int rows=itemsCartDao.updateByItemId(requiredQuantity,it.get().getSalesTax(), it.get().getTotalCost(), itemId, customer.getUser_Name());
		
		if(rows>0) {
			return it.get();
		}
		return new ItemsCart();
	}

	@Override
	public Optional<ItemsCart> searchByItemIdAndName(Customer customer, String itemId) {
		// TODO Auto-generated method stub
		
		
		return itemsCartDao.findByItemIdAndUserName(itemId, customer.getUser_Name());
	}


//	if(modifiedQuantity <1) {
//		System.out.println("enter positive value greater than 0");
//		return false;
//	}
//	if(itemsService.searchItemsById(itemId, modifiedQuantity) && itemsCartDao.searchItemById(itemId, customer)) {
//		ItemDetails item=itemsService.searchItemsById(itemId);	
//		double tax=getTax(item.getItemCategory());
//		
//		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();
//
//		double totalCost=cost*modifiedQuantity;
//
//		itemsCartDao.modifyQuantityOfCartItems(customer, itemId, modifiedQuantity, tax ,totalCost);
//		
//		return true;
//	}
//	return false;
}
