package com.xyzretail.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.Customer;
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
	public ItemsCartList getItemsInCart(String name) {
		List<ItemsCart> cart=itemsCartDao.findByUserName(name);
		ItemsCartList cartList=new ItemsCartList(cart);
		return cartList;
	}

	@Override
	public ItemsCart deleteItemByItemId(String customer, String itemId) {
		
		Optional<ItemsCart> itemOpt=itemsCartDao.findByItemIdAndUserName(itemId, customer);
		
		if(itemOpt.isPresent()) {
			itemsCartDao.deleteItemByItemId(itemId, customer);
			return itemOpt.get();
		}
		return new ItemsCart();
		
	}

	@Override
	public ItemsCart updateByItemId(String customer, String itemId, int requiredQuantity) {
	
		Optional<ItemsCart> item=searchByItemIdAndName(customer, itemId);
		
		//int rows=itemsCartDao.updateByItemId(requiredQuantity,it.get().getSalesTax(), it.get().getTotalCost(), itemId, customer);
		if(item.isPresent()) {
			ItemsCart itemCart=item.get();
			double unitCost=itemCart.getUnitPrice();
			int availQuantity=itemCart.getRequiredQuantity();
			
			//double cost=itemCart.getTotalCost()
		}
		if(rows>0) {
			return it.get();
		}
		return new ItemsCart();
	}

	@Override
	public Optional<ItemsCart> searchByItemIdAndName( String itemId,String userName) {
		return itemsCartDao.findByItemIdAndUserName(itemId, userName);
	}

	@Override
	public ItemsCart addItemtoCart(Customer customer, String itemId, int requiredQuantity) {
		// TODO Auto-generated method stub
		return null;
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
