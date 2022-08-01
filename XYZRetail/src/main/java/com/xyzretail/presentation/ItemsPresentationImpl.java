package com.xyzretail.presentation;



import java.util.List;
import java.util.Scanner;

import com.xyzretail.bean.DateTime;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.persistence.DummyClassDateTime;
import com.xyzretail.service.CartService;
import com.xyzretail.service.CartServiceImpl;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.ItemsServiceImpl;

public class ItemsPresentationImpl implements ItemsPresentation{
	
	private ItemsService itemsService=new ItemsServiceImpl();
	private CartService cartService=new CartServiceImpl();
	private DummyClassDateTime dummyClassDateTime=new DummyClassDateTime();

	
	
	@Override
	public void showMenu(String customer) {
		System.out.println("=============================");
		System.out.println("1. Show All Items");
		System.out.println("2. Do you wants to shop?");
		System.out.println("3. See items in cart?");
		System.out.println("4. Generate Bill");
		System.out.println("5. Show Purchased Date and Time");
		System.out.println("6. Exit");
		System.out.println("================================");
		
	}
	
	@Override
	public void performMenu(int ch,String customer) {
		Scanner sc=new Scanner(System.in);
		try {
		switch(ch) {
			
		case 1: 
			List<ItemDetails> items=itemsService.getAllItems();

			System.out.println("Available items:");
			System.out.println("\tID \t \t Category \t \t  Item Name \t \t \t PRICE \t \t Avaliable Quantity");

			System.out.println();
			
			for(ItemDetails item:items) {

				System.out.println("\t"+item.getItemId()+"\t \t "+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t  "+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

				//System.out.println("\t\t"+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t"+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

				System.out.println(item.getItemId()+"\t \t "+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t  "+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

			}
			System.out.println();
			break;	
	
		case 2:
			System.out.println("Do you wants to shop : If YES enter 1, If NO enter 0");
			int chs=sc.nextInt();
			while(chs!=0) {
				
				System.out.println("Enter Item Id you wants to buy: ");
				String id=sc.next();
				System.out.println("Enter the quantity you wants to buy : ");
				int requiredQuantity=sc.nextInt();
				
				boolean added=cartService.addItemToCart(customer,id, requiredQuantity);
				if(added) {
					System.out.println("Item added to cart is successfully : "+id+"  "+"  : "+requiredQuantity);
				}
				System.out.println("Do you wants to shop : If YES enter 1, If NO enter 0");
				chs=sc.nextInt();	
			}
			break;
			
		case 3:
			System.out.println("Items that are avaialble in cart are:");
			List<ItemsCart> itemsCart=cartService.getAllItemsInCart(customer);
			System.out.println("ID \t \t Item Name \t \t \t UnitPrice \t \t Purchased Quantity \t \t TotalCost");
			for(ItemsCart item:itemsCart) {

				System.out.println(item.getItem().getItemId()+"\t \t "+item.getItem().getItemName()+"\t \t"+item.getItem().getItemPrice()+"\t \t"+
				item.getPurchaseQuantity()+"\t \t"+item.getTotalCost()+"\t \t");

			}
			System.out.println();
			break;
			
		case 4: 
			System.out.println("Your Total Bill Amount is : ");
			double itemsBill=itemsService.generateBill();
			if(itemsBill!=0) {
				System.out.println(itemsBill);
			}
			else
				System.out.println("");
			break;
		
		case 5:
			System.out.println("Purchased Time \t \t Purchased Date ");
			
//			boolean add=dummyClassDateTime.addDateTime();
			List<DateTime> dt=dummyClassDateTime.showDateTime();
			
			for(DateTime dtt:dt) {
				System.out.println(dtt.getTime()+"\t \t"+dtt.getDate());
			}
			break;
		
	
		case 6:
			System.out.println("\n*************** Thanks for using our Shopping Basket Application!! ************");
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