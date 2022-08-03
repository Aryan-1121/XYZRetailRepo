package com.xyzretail.presentation;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.xyzretail.bean.ItemsCart;
import com.xyzretail.service.CartService;
import com.xyzretail.service.CartServiceImpl;

public class CartPresentation implements Cart {

	private CartService cartService=new CartServiceImpl();

		
	@Override
	public void showCartMenu() {
		
		System.out.println("____________________________________\n");
		System.out.println("1. Add Items to your Cart ");
		System.out.println("2. Remove Item from Cart ");
		System.out.println("3. Modify Your Item's Quantity in your cart ");
		System.out.println("4. See Your Cart ");
		System.out.println("0. Go To Main Menu ");
		System.out.println("____________________________________\n");
		
	}

	@Override
	public void performMenuCart(int ch,String customer) {
		
		Scanner sc=new Scanner(System.in);
		
		try {
			
			switch(ch) {
			
			case 1:
				System.out.println("To Add Item Enter 1 And Enter 0 To Exit : ");
				int chs=sc.nextInt();
				while(chs!=0) {
					
					System.out.println("Enter Item Id : ");
					String id=sc.next();
					System.out.println("Enter the Item's Quantities : ");
					int requiredQuantity=sc.nextInt();
					
					boolean added=cartService.addItemToCart(customer,id, requiredQuantity);
					if(added) {
						System.out.println("Item added to cart is successfully : "+id+"  "+"  : "+requiredQuantity+"\n");
						
					}else{ System.out.println("Enter Correct Item Id or either Item is Not Available\n");}
					System.out.println("To Add Item Enter 1 : ");
					chs=sc.nextInt();	
				}
				break;
				
			case 2:
				List<ItemsCart> itemsCart1 =cartService.getAllItemsInCart(customer);
				if(itemsCart1.isEmpty())
					System.out.println("\nYour Cart is Already Empty, Please Add Items In Your Cart :)\n");
				
				else {
					System.out.println("Enter Item ID to Remove :");
					String itemId= sc.next();
					int rows =cartService.unselectFromCart(itemId, customer);
					if (rows==0)
						System.out.println("You don't have this item in your Cart :) \n");
					else
						System.out.println("Item removed sucessufully !!!\n");

				}
				
				break; 
			
			
			case 3:
				System.out.println("Enter Item's Id to Modify:\n");
				String id=sc.nextLine();
				System.out.println("Enter the New Quantity :");
				int quantity=sc.nextInt();
							
				if(cartService.modifyItemsInCart(customer, id, quantity)) {
//					System.out.println("===============");
					System.out.println(customer);
					System.out.println(id);
					System.out.println(quantity);
					System.out.println("Updated Item Id : "+id+ " with new quantity of : "+ quantity+"\n");
					performMenuCart(3,customer);
				}
				else {
					System.out.println("Unable to update you Cart\n");
				}

			break;
			
			case 4:
				
				System.out.println("Items Present in Your Cart :\n");
				List<ItemsCart> itemsCart=cartService.getAllItemsInCart(customer);
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------|");
				System.out.println("|                                                                                                                                                          |");
				System.out.println("|\t \t ID \t \t Item Name \t \t \t UnitPrice \t \t Tax \t \t Purchased Quantity  \t \t TotalCost ");
				System.out.println("|                                                                                                                                                          |");
				System.out.println("|----------------------------------------------------------------------------------------------------------------------------------------------------------|");
				double totalCost=0;
				for(ItemsCart item:itemsCart) {
					
					System.out.println("\t \t "+item.getItem().getItemId()+" \t \t "+item.getItem().getItemName()+" \t \t \t"+item.getItem().getItemPrice()+"\t \t \t"+item.getSalesTax()+"\t \t \t"+item.getPurchaseQuantity()+"\t \t \t"+item.getTotalCost());
					totalCost +=item.getTotalCost();
				}
				
				System.out.println("|                                                                                                                                                          |");
				System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
				
				System.out.println();
				System.out.println("Total Cart Price : " +totalCost+"\n");
				
				break;
			
			
			case 0:
//				System.out.println("***************** Now You Are On Main Menu ********************");
				return;
			
			default:
				System.out.println("Invalid Choice");
				break;
			
			}	
		}
		
		
		
		
		catch(NullPointerException nullPointer) {
			System.out.println("Enter Correct Details ");}
		catch(InputMismatchException ex) {
			System.out.println("Enter correct input");
		}
		catch(Exception exception) {
			System.out.println(exception);
		}
		
		
	}

}
