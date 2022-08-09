package com.xyzretail.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xyzretail.bean.ItemBill;
//import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;

@Repository("itemsBillDao")
public class ItemsBillDaoImpl implements ItemsBillDao {
	private ItemsCartDao cart;
	
	

	public void setCart(ItemsCartDao cart) {
		this.cart = cart;
	}



	@Override
	public ItemBill generateBill( String customer) {
		
		List<ItemsCart> item=cart.getAllItemsInCart(customer);
		ItemBill bill;
		double grandTotal=0;
		for(ItemsCart items:item) {
			grandTotal+=items.getTotalCost();
		}
		bill=new ItemBill(customer,item,grandTotal);
		return bill;
		}

}
