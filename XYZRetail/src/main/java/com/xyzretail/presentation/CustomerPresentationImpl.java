package com.xyzretail.presentation;

import java.util.List;
import java.util.Scanner;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.persistence.CustomerDao;
import com.xyzretail.persistence.CustomerDaoImpl;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.ItemsServiceImpl;

public class CustomerPresentationImpl implements CustomerPresentation {

	private ItemsService itemsService=new ItemsServiceImpl();
	private CustomerDao CustomerDao= new CustomerDaoImpl();
	
	@Override
	public void showMenuCustomer() {
		System.out.println("=============================");
		System.out.println("1. Enter your details for Registration ");
		System.out.println("2. Enter you details for Login");
		System.out.println("3. Exit");
		System.out.println("================================");
		
	}

	@Override
	public void performMenuCustomer(int choice) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		try {
		switch(choice) {
		case 1: 
			System.out.println("Enter Your UserName");
			String userName= sc.next();
			
			System.out.println("Enter Your Password");
			String password= sc.next();
			
			
			Customer customer = new Customer(userName, password);
			
			
			boolean isAdded = CustomerDao.addCustomer(customer);
			
			if(isAdded)
				System.out.println("Registration Successful !!! ");
			else 
				System.out.println("Something Went Wrong ..");
			
			break;

		
			
		case 2:
			Customer loginCustomer = new Customer();

			System.out.println("Enter Your UserName");
			loginCustomer.setUserName(sc.next());
			
			System.out.println("Enter Your Password");
			loginCustomer.setUserPassword(sc.next());
					
			boolean isVerified = CustomerDao.validateCustomer(loginCustomer);
			
			if(isVerified)
				System.out.println("LOGIN SUCCESSFULL !!!");
			
			else 
				System.out.println("SOMETHING WENT WRONG .. ");
			
		
			
			int check=1;
			
			if(isVerified && check==1)
			{
				System.out.println("To See All Items, Please Enter 1 ");
				check=sc.nextInt();
				List<ItemDetails> items=itemsService.getAllItems();
				System.out.println("Available items:");
				System.out.println("Item Name  \t Cost of each Unit \t Avaliable Quantity");
				
				for(ItemDetails item:items) {
					System.out.println(item.getItemName()+"\t"+item.getItemPrice()+"\t"+item.getAvailableQuantity());
				}
				break;	
			}
			else {
				System.out.println("Please Login Again To See All Items !!!");
			}
			break;
	
		case 3:
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
