package com.xyzretail.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;
import com.xyzretail.persistence.ItemsCartDao;


@Service
public class ItemsCartServiceImpl implements ItemsCartService {
	
	@Autowired
	private ItemsCartDao itemsCartDao;
	
	@Autowired
	private ItemDetailService itemDetailService;
	
	@Autowired
	private RestTemplate restTemplate;
	
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
	
//		
//		ItemsCart cart=searchByItemIdAndName(itemId, customer);
//		if(requiredQuantity<1) {
//			return null;
//		}
//		ItemDetail itemdetail=itemDetailService.findByItemId(itemId);
//		ItemDetail isPresent=itemDetailService.findByItemId_AndAvailable_Quantity(itemId, requiredQuantity);
//		if(isPresent!=null && cart!=null) {
//			double tax=getTax(itemdetail.getItemCategory());
//			double cost=(itemdetail.getItemPrice()*(double)(tax*0.01))+itemdetail.getItemPrice();
//			double totalCost=cost*requiredQuantity;
//			if(itemsCartDao.updateByItemId(requiredQuantity, totalCost, itemId, customer)>0)
//				return searchByItemIdAndName(itemId, customer);
//		}
//		return new ItemsCart();
//		}

		ItemsCart itemCart=searchByItemIdAndName(itemId, customer);
		if(itemCart!=null) {
			
			double unitCost=itemCart.getUnitPrice();//price of item in cart
			ItemDetail itemDetail=restTemplate.getForObject("http://localhost:8083/itemDetail/"+itemId+"/"+requiredQuantity ,ItemDetail.class);

			//int availQuantity=itemCart.getRequiredQuantity();//quantity in cart->8 required 3


			if(itemDetail!=null) {
				double totalCost=(unitCost*requiredQuantity)*getTax(itemDetail.getItemCategory())*0.01;
				int rows=itemsCartDao.updateByItemId(requiredQuantity, totalCost, itemId, customer);
				if(rows>0) {
					//System.out.println(searchByItemIdAndName(itemId, customer).get());
					return searchByItemIdAndName(itemId, customer);
				}
				else {
					System.out.println(itemCart);
					return itemCart;
				}
				
			}
			else 
				return itemCart;
			
		}
		else 
			return new ItemsCart();}
		
	
	@Override
	public ItemsCart searchByItemIdAndName( String itemId,String userName) {
		return itemsCartDao.findByItemIdAndUserName(itemId, userName).orElse(null);
	}
	
	@Override
	public ItemsCart addItemtoCart(String customer, String itemId, int requiredQuantity) {
		
		if(requiredQuantity<0) {
			return null;
		}
		ItemsCart itemsCart=searchByItemIdAndName(itemId, customer);
		ItemDetail itemdetail=itemDetailService.findByItemId(itemId);
		ItemDetail isPresent=itemDetailService.findByItemId_AndAvailable_Quantity(itemId, requiredQuantity);
		if(isPresent!=null) {
			System.out.println(" adding ");

			double tax=getTax(itemdetail.getItemCategory());
			double cost=(itemdetail.getItemPrice()*(double)(tax*0.01))+itemdetail.getItemPrice();
			double totalCost=cost*requiredQuantity;
			
			if(itemsCart==null) {
				if(itemsCartDao.addItemToCart(itemId, itemdetail.getItemName(), itemdetail.getItemPrice(),customer, requiredQuantity,tax, totalCost)>0)
					return searchByItemIdAndName(itemId, customer);
			}
			else {
				System.out.println("alreasy exist -> adding ");
				requiredQuantity+=itemsCart.getRequiredQuantity();
				totalCost+=itemsCart.getTotalCost();
				itemsCartDao.deleteItemByItemId(itemId, customer);
				if(itemsCartDao.addItemToCart(itemId, itemdetail.getItemName(), itemdetail.getItemPrice(),customer, requiredQuantity,tax, totalCost)>0)
					return searchByItemIdAndName(itemId, customer);
				
			}
		}
//		else {
//			System.out.println("returning null");
//			return null;
//		}
		System.out.println("returnnig new itemsCart");
		return new ItemsCart();
		}
//		if(item.isPresent()) {
//			ItemsCart itemCart=item.get();
//			ItemDetail itemDetail=restTemplate.getForObject("http://localhost:8083/itemDetail/"+itemId+"/"+(itemCart.getRequiredQuantity()+requiredQuantity), ItemDetail.class);
//			System.out.println(itemDetail);
//			if(itemDetail!=null) {
//				double totalCost=itemDetail.getItemPrice()*(itemCart.getRequiredQuantity()+requiredQuantity)*getTax(itemDetail.getItemCategory())*(double)0.01;
//				requiredQuantity+=itemCart.getRequiredQuantity();
//				int rows=itemsCartDao.addItemToCart(itemId, itemDetail.getItemName(), itemDetail.getItemPrice(), customer, requiredQuantity, getTax(itemDetail.getItemCategory()), totalCost);
//				if(rows>0) {
//					return searchByItemIdAndName(itemId, customer).get();
//				}
//				else {
//					return new ItemsCart();
//				}
//			}
//			else {
//				return itemCart;
//			}
//		}
//		else {
//			ItemDetail itemDetail=restTemplate.getForObject("http://localhost:8083/itemDetail/"+itemId+"/"+requiredQuantity, ItemDetail.class);
//			System.out.println(itemDetail);
//			if(itemDetail!=null) {
//				double totalCost=(itemDetail.getItemPrice()*requiredQuantity)*(getTax(itemDetail.getItemCategory())*(double)0.01);	
//				int rows=itemsCartDao.addItemToCart(itemId, itemDetail.getItemName(), itemDetail.getItemPrice(), customer, requiredQuantity, getTax(itemDetail.getItemCategory()), totalCost);
//				if(rows>0) {
//					return searchByItemIdAndName(itemId, customer).get();
//				}
//				else {
//					return new ItemsCart();
//				}
//			}
//		}
	

	@Override
	public ItemsCartList deleteAllItemsInCart(String customer) {
		if(itemsCartDao.deleteAllByUserName(customer)>0)
			return getItemsInCart(customer);
		return new ItemsCartList();
	}
				

	
	
//	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
////		System.out.println("customer name ="+customer);
//		if (reqQuantity <1 )
//		{
//			System.out.println("enter positive value !!");
//			return false ;
//		}
//		ItemDetails item=itemsService.searchItemsById(itemId);
//		if(itemsService.searchItemsById(itemId, reqQuantity)) {
//		
//		double tax=getTax(item.getItemCategory());
//		
//		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();
//
//		double totalCost=cost*reqQuantity;
//		
//		
//		if(!itemsCartDao.searchItemById(itemId, customer)){
//			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
//		}
//		else {
//			ItemsCart itemCart=itemsCartDao.getItemById(itemId, customer);
//			reqQuantity+=itemCart.getPurchaseQuantity();
//			totalCost+=itemCart.getTotalCost();
//			itemsCartDao.unselectFromCart(itemId, customer);
//			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
//		}
//	}
//	else {
//
//		System.out.println(reqQuantity+" "+ item.getItemName() +" is Not available in our Stock :( ");
//		return false;
//	}
//	}

}
