package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;


@Service("billService")
public class BillServiceImpl implements BillService {
	
	@Autowired
	private ItemsCartService cart;

	@Override
	public ItemBill generateBill(String customer) {
		ItemsCartList itemCart=cart.getItemsInCart(customer);
		List<ItemsCart> item=itemCart.getItemsCartList();
		ItemBill bill;
		double grandTotal=0;
		for(ItemsCart items:item) {
			grandTotal+=items.getTotalCost();
		}
		bill=new ItemBill(customer,item,grandTotal);
		return bill;
	}
	
	

}
