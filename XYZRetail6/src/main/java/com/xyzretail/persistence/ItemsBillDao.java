package com.xyzretail.persistence;

import com.xyzretail.bean.ItemBill;

public interface ItemsBillDao {
	
	 ItemBill generateBill(String customer);

}
