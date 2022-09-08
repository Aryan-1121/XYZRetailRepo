package com.xyzretail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemBill;


@Service("billService")
public class BillServiceImpl implements BillService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ItemBill generateBill(String customer) {
		ItemBill bill=restTemplate.getForObject("http://itemDetails-Cart-service/cart/bill/"+customer, ItemBill.class);
		return bill;
	}
	
	
	
	

}
