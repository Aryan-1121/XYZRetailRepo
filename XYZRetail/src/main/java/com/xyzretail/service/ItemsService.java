package com.xyzretail.service;

import java.util.List;

<<<<<<< HEAD
import com.xyzretail.bean.Item;
import com.xyzretail.client.Customer;
=======
import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;
>>>>>>> branch 'master' of https://github.com/Nagalakshmi-S/XYZRetailRepo

public interface ItemsService {
<<<<<<< HEAD
//	double getBooksCost(int requiredBooks);
//	double getCdCost(int requiredCds);
//	double getCosmeticsCost(int requiredCosmetics);
//	double generateBill();
	List<Item> getAllItems();
   Item searchItemsById(String id,int reqQuantity);

	boolean addItem(Item item);

	boolean addCustomer(Customer customer);

	List<Item> getItemDetails();

	boolean removeCustomer(Customer customer);

	double generateBill();

	double getTax(Item item);

	boolean validateCustomer();

	double setTax(Item item);

	double calculateBooksCost(Item item);

	double calculateCDCost(Item item);

	double calculateCosmeticsCost(Item item);

	double calculateTaxAmount(Item category);

=======
	double getBooksCost(int requiredBooks);
	double getCdCost(int requiredCds);
	double getCosmeticsCost(int requiredCosmetics);
	double generateBill();

	boolean addCustomer(Customer customer);	//		To add new user/Customer
	
	boolean validateCustomer (Customer Customer);
	
	List<ItemDetails> getAllItems();
	ItemDetails searchItemsById(String id,int reqQuantity);
>>>>>>> branch 'master' of https://github.com/Nagalakshmi-S/XYZRetailRepo
}
