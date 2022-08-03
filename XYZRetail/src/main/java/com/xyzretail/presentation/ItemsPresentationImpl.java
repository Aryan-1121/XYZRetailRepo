package com.xyzretail.presentation;

import java.util.InputMismatchException;
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
	Cart cartPresentation=new CartPresentation();
	private BillService bill=new BillServiceImpl();

	@Override
	public void showMenu(String customer) {
		
		System.out.println("____________________________________\n");
		System.out.println("1. Show All Items");
		System.out.println("2. Wants to Shop ?");
		System.out.println("3. Generate the Bill");
		System.out.println("4. Exit");
		System.out.println("____________________________________\n");
		
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

//			System.out.println("Available items:\n");
			
			System.out.println("|----------------------------------------------------- Available Items ------------------------------------------------------------------------------------|");
			System.out.println("|              	                                                                                                                                           |");
			System.out.println("|\t \t ID \t \t Category \t  Item Name \t \t  UnitPrice \t \t Avaliable Quantity ");
			System.out.println("|                                                                                                                                                          |");
			System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------|");
			
			
			for(ItemDetails item:items) {

				//System.out.println("\t\t"+item.getItemCategory()+"\t \t"+item.getItemName()+"\t \t"+item.getItemPrice()+"\t \t \t"+item.getAvailableQuantity());

				System.out.println(" \t \t "+item.getItemId()+"\t \t "+item.getItemCategory()+"\t \t  "+item.getItemName()+"\t \t \t"+item.getItemPrice()+"\t \t \t \t "+item.getAvailableQuantity());
				
			}
			System.out.println("|                                                                                                                                                          |");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println();
			break;	
	
		case 2:
			
			while(true) {
				System.out.println("************ Items Menu *************");
				cartPresentation.showCartMenu();
				System.out.println("Enter Your Choice ");
				int ch1=sc.nextInt();
				if(ch1!=0) {
				cartPresentation.performMenuCart(ch1,customer);
				}
				else
					return;
			}
			
		case 3: 
			
			ItemBill itemsBill=bill.generateBill(customer);
				
				List<ItemsCart> itemsCarts =cartService.getAllItemsInCart(customer);

				if (!itemsCarts.isEmpty() && itemsBill!=null ) {
					System.out.println("Your Bill Details are : ");

					System.out.println("\t \t Customer Name : "+itemsBill.getCustomerName()+"\n");
					
					
					System.out.println("-------------------------------------------------------- Purchased items -----------------------------------------------------------------------------------");
					System.out.println("|                                                                                                                                                          |");
					System.out.println("\t \t ID \t \t Item Name \t \t \t UnitPrice \t \t Tax\t \t Purchased Quantity  \t \t TotalCost");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(ItemsCart item:itemsBill.getCart()) {

						System.out.println(" \t \t"+item.getItem().getItemId()+"\t \t "+item.getItem().getItemName()+"\t \t \t"+item.getItem().getItemPrice()+"\t \t \t"+item.getSalesTax()+"\t \t \t"+item.getPurchaseQuantity()+"\t \t \t"+item.getTotalCost());
						
						itemsService.updateRecord(item.getItem().getItemId(), item.getPurchaseQuantity());
					}
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("|                                                                                                                                                         |");
					System.out.println("|	Total Amount to be Paid : "+itemsBill.getGrandTotal());
					System.out.println("|                                                                                                                                                         |");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
					boolean isComplete = transactionService.performTransaction(customer);
					if(isComplete)
						System.out.println("Transaction completed !!!\n");
					else 
						System.out.println("Something Went Wrong !!\n");
					transactionService.insertIntoOrderTable(customer);		// Inserting into order table
					cartService.deleteItemFromCart(customer);		
				}
				else
					System.out.println("#####      Your cart is empty !!    #####\n");

			break;
		
	
		case 4:
			System.out.println("\n*************** Thanks for using our Shopping Basket Application!! ************");
			System.exit(0);
			
			
		
			
		default:
			System.out.println("Invalid Choice");
			break;
			
			
			
		}	
		
	}catch(NullPointerException nullPointer) {
		System.out.println("Enter Correct Details ");}
	catch(InputMismatchException ex) {
		System.out.println("Enter correct input");
	}
	catch(Exception exception) {
		System.out.println(exception);
	}
}
}