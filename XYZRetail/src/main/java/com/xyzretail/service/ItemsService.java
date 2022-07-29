package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;


public interface ItemsService {

	List<ItemDetails> getAllItems();
	
	ItemDetails searchItemsById(String itemId,int availableQuantity);

	boolean addItem(ItemDetails item);

	boolean addCustomer(Customer customer);

	List<ItemDetails> getItemDetails();

	boolean removeCustomer(Customer customer);

	double generateBill();

	double getTax(ItemDetails item);

	boolean validateCustomer();

	double setTax(ItemDetails item);

	double calculateBooksCost(ItemDetails item);

	double calculateCDCost(ItemDetails item);

	double calculateCosmeticsCost(ItemDetails item);

	double calculateTaxAmount(ItemDetails category);

	double getBooksCost(int requiredBooks);
	double getCdCost(int requiredCds);
	double getCosmeticsCost(int requiredCosmetics);



}
