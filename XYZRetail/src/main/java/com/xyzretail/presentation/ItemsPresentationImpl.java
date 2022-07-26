package com.xyzretail.presentation;

import java.util.List;
import java.util.Scanner;

import com.xyzretail.bean.Item;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.ItemsServiceImpl;

public class ItemsPresentationImpl implements ItemsPresentation{
	
	private ItemsService itemsService=new ItemsServiceImpl();
	
	@Override
	public void showMenu() {
		System.out.println("======================================");
		System.out.println("1. Show All Items");
		System.out.println("2. Do you wants to shop?");
		System.out.println("3. Generate Bill");
		System.out.println("4. Exit");
	}
	
	@Override
	public void performMenu(int choice) {
		Scanner sc=new Scanner(System.in);
		try {
		switch(choice) {
		case 1: 
			List<Item> items=itemsService.getAllItems();
			System.out.println("Available items:");
			System.out.println("Item Name  \t Cost of each Unit \t Avaliable Quantity");
			for(Item item:items) {
				System.out.println(item.getItemName()+"\t"+item.getItemPrice()+"\t"+item.getItemLeft());
			}
			break;	
	
		case 2:
//			System.out.println("Do you wants to shop : If YES enter 1, If NO enter 0");
			int ch=1;
			while(ch!=0) {
				
				System.out.println("Enter Item Id you wants to buy: ");
				String id=sc.next();
				System.out.println("Enter the quantity you wants to buy : ");
				int requiredQuantity=sc.nextInt();
				
				Item item=itemsService.searchItemsById(id,requiredQuantity);
				if(item!=null) {
					System.out.println("Item added to cart is successfully : "+item+" : "+requiredQuantity);
				}
				System.out.println("Do you wants to shop : If YES enter 1, If NO enter 0");
				ch=sc.nextInt();
			}
		
			break;
		case 3: 
			System.out.println("Your Total Bill Amount is : ");
//			ItemsBill itemsbill=new ItemsService.generateBill();
//			if(itemsBill!=null) {
//				System.out.println(itemsBill);
//			}
//			else
//				System.out.println("");
			break;
		
		case 4:
			System.out.println("Thanks for using Shopping Basket Application!!");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
			break;
		}	
	}
		catch(Exception exception) {
			System.out.println("");
		}
}
}