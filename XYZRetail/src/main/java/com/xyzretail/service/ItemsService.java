package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Item;
import com.xyzretail.client.Customer;

public interface ItemsService {
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

}
