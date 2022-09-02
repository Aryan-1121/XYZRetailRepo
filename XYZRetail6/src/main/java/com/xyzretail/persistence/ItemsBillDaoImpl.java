package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.ItemBill;
//import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;

public class ItemsBillDaoImpl implements ItemsBillDao {


	@Override
	public ItemBill generateBill(String customer) {
		ItemsCartDao cart=new ItemsCartDaoImpl();
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
