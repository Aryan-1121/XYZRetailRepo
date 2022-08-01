package com.xyzretail.presentation;

import java.util.List;
import java.util.Scanner;

import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.service.BillService;
import com.xyzretail.service.BillServiceImpl;
import com.xyzretail.service.CartService;
import com.xyzretail.service.CartServiceImpl;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.ItemsServiceImpl;
import com.xyzretail.service.TransactionService;
import com.xyzretail.service.TransactionServiceImpl;

public class ItemsPresentationImpl implements ItemsPresentation{
	
	private ItemsService itemsService=new ItemsServiceImpl();
	private CartService cartService=new CartServiceImpl();
	private TransactionService transactionService = new TransactionServiceImpl();
	
	private BillService bill=new BillServiceImpl();

	@Override
	public void showMenu(String customer) {
		System.out.println("=============================");
		System.out.println("1. Show All Items");
		System.out.println("2. Do you wants to shop?");
		System.out.println("3. See Your Cart");
		System.out.println("4. Remove Item from Cart");
		System.out.println("5. Generate the Bill");
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

//			System.out.println("Available items:\n");
//			System.out.println("\t\tCategory \t\t  Item Name \t \t  PRICE \t \t Avaliable Quantity");

			System.out.println("Available items:");
			System.out.println("ID \t \t Category \t \t  Item Name \t \t \t PRICE \t \t Avaliable Quantity");

			System.out.println();
			
			for(ItemDetails item:items) {

				//System.out.println("\t\t"+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t"+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

				System.out.println(item.getItemId()+"\t \t "+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t  "+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

			}
			System.out.println();
			break;	
	
		case 2:
			System.out.println("Add Items To Your Cart : If YES enter 1, If NO enter 0");
			int chs=sc.nextInt();
			while(chs!=0) {
				
				System.out.println("Enter Item Id you wants to buy: ");
				String id=sc.next();
				System.out.println("Enter the Quantities you wants to buy : ");
				int requiredQuantity=sc.nextInt();
				
				boolean added=cartService.addItemToCart(customer,id, requiredQuantity);
				if(added) {
					System.out.println("Item added to cart is successfully : "+id+"  "+"  : "+requiredQuantity);
				}else{ System.out.println("Enter correct item id or item is not available");}
				System.out.println("Do you wants to shop : If YES enter 1, If NO enter 0");
				chs=sc.nextInt();	
			}
			break;
			
		case 3:
			System.out.println("Items that are in your cart are :");
			List<ItemsCart> itemsCart=cartService.getAllItemsInCart(customer);
			System.out.println("\t \t ID \t \t Item Name \t \t \t UnitPrice \t \t Tax\t \t Purchased Quantity  \t \t TotalCost");
			double totalCost=0;
			for(ItemsCart item:itemsCart) {
				
				System.out.println("\t \t"+item.getItem().getItemId()+"\t \t "+item.getItem().getItemName()+"\t \t \t"+item.getItem().getItemPrice()+"\t \t \t"+item.getSalesTax()+"\t \t \t"+item.getPurchaseQuantity()+"\t \t \t"+item.getTotalCost());
				totalCost +=item.getTotalCost();
				

			}
			System.out.println();
			System.out.println("Total Cart Price : " +totalCost );
			
			break;
			
			
		case 4:
			
			List<ItemsCart> itemsCart1 =cartService.getAllItemsInCart(customer);
			if(itemsCart1.isEmpty())
				System.out.println("Your Cart is Already Empty, Please Add Items In Your Cart :)");
			
			else {
				System.out.println("Enter Item ID to remove from cart :");
				String itemId= sc.next();
				int rows =cartService.unselectFromCart(itemId, customer);
				if (rows==0)
					System.out.println("You don't have this item in your Cart :) ");
				else
					System.out.println("Item removed sucessufully !!!");

			}
			
			break; 
			
		case 5: 
			
			ItemBill itemsBill=bill.generateBill(customer);
				
				List<ItemsCart> itemsCarts =cartService.getAllItemsInCart(customer);

				if (!itemsCarts.isEmpty() && itemsBill!=null ) {
					System.out.println("Your Bill Details are : ");

					System.out.println("\t \t Customer Name : "+itemsBill.getCustomerName());
					System.out.println("\t \t Purchased items:");
					System.out.println("\t \t ID \t \t Item Name \t \t \t UnitPrice \t \t Tax\t \t Purchased Quantity  \t \t TotalCost");
					for(ItemsCart item:itemsBill.getCart()) {

						System.out.println("\t \t"+item.getItem().getItemId()+"\t \t "+item.getItem().getItemName()+"\t \t \t"+item.getItem().getItemPrice()+"\t \t \t"+item.getSalesTax()+"\t \t \t"+item.getPurchaseQuantity()+"\t \t \t"+item.getTotalCost());
						
						itemsService.updateRecord(item.getItem().getItemId(), item.getPurchaseQuantity());
					}
					System.out.println("Total Amount to be Paid : "+itemsBill.getGrandTotal());
					
					boolean isComplete = transactionService.performTransaction(customer);
					System.out.println(customer);
					if(isComplete)
						System.out.println("Transaction completed !!!");
					else 
						System.out.println("Something Went Wrong !!");
					transactionService.insertIntoOrderTable(customer);		// Inserting into order table
					cartService.deleteItemFromCart(customer);		
				}
				else
					System.out.println("Your cart is empty !!");

			break;
		
	
		case 6:
			System.out.println("\n*************** Thanks for using our Shopping Basket Application!! ************");
			System.exit(0);
			
			
		
			
		default:
			System.out.println("Invalid Choice");
			break;
			
			
			
		}	
		
	}catch(NullPointerException nullPointer) {
		System.out.println("Enter Correct Details ");}
		catch(Exception exception) {
			System.out.println(exception);
			
		}
}
}