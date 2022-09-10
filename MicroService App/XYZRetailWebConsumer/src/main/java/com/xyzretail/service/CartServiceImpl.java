package com.xyzretail.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;
//import com.xyzretail.persistence.ItemsCartDao;
@Service("cartService")
public class CartServiceImpl implements CartService {
//	private ItemsCartDao itemsCartDao;
//	@Autowired
//	private ItemsService itemsService;
	
	@Autowired
	private RestTemplate restTemplate;
//	
//	@Autowired
//	public void setItemsCartDao(ItemsCartDao itemsCartDao) {
//		this.itemsCartDao = itemsCartDao;
//	}
	
//	@Autowired
//	public void setItemsService(ItemsService itemsService) {
//		this.itemsService = itemsService;
//	}
	
	@Override
	public List<ItemsCart> getAllItemsInCart(String customer) {
		ItemsCartList cartList= restTemplate.getForObject("http://itemDetails-Cart-service/cart/all/"+customer, ItemsCartList.class);
		if(cartList!=null)
			return cartList.getItemsCartList();
		return null;
	}

	@Override
	@Nullable
	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
		
//		ItemsCart itemCart=restTemplate.postForObject("http://itemsCart-service/cart/add/"+itemId+"/"+reqQuantity+"/"+customer, ItemsCart.class);
		URI itemCart =restTemplate.postForLocation("http://itemDetails-Cart-service/cart/add/"+itemId+"/"+reqQuantity+"/"+customer,ItemsCart.class);

		System.out.println(itemCart);
//		if(itemCart!=null) {
//			return true;
//		}
		
		return true;
		
	}


	
	@Override
	public void deleteItemFromCart(String customer) {
		restTemplate.delete("http://itemDetails-Cart-service/cart/deleteall/"+customer, ItemsCartList.class);
		
	}

	@Override
	public int unselectFromCart(String itemId, String customer) {
		restTemplate.delete("http://itemDetails-Cart-service/cart/delete/"+itemId+"/"+customer, ItemsCart.class);
		return 1;
	}

	
	//-----------------------------------------------------------------------------------------------------
	
	@Override
	public boolean modifyItemsInCart(String customer, String itemId, int modifiedQuantity) {
		ItemDetail item1=restTemplate.getForObject("http://itemDetails-Cart-service/itemDetail/"+itemId,ItemDetail.class);

		System.out.println(item1);
		if (item1.getAvailableQuantity() < modifiedQuantity)
			return false ;
		else
		if(getItemByIDandUser(itemId,customer)) {
			restTemplate.put("http://itemDetails-Cart-service/cart/update/"+ itemId+"/"+modifiedQuantity+"/"+customer,ItemsCart.class);	
		}
		return false;
	}
	
	
	//----------------------------------------------------------------------------------------------------
	

	@Override
	public boolean getItemByIDandUser(String itemId, String customer) {
		ItemsCart item=restTemplate.getForObject("http://itemDetails-Cart-service/cart/all/"+itemId+"/"+customer, ItemsCart.class);
		if(item!=null) {
			return true;
		}
		return false;
	
	}
		
}
