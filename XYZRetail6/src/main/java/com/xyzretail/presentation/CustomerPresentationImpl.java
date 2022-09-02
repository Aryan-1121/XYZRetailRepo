package com.xyzretail.presentation;


import java.util.Scanner;
import com.xyzretail.bean.Customer;
import com.xyzretail.service.CustomerService;
import com.xyzretail.service.CustomerServiceImpl;

public class CustomerPresentationImpl implements CustomerPresentation {

	ItemsPresentation itemsPresentation=new ItemsPresentationImpl();
	private CustomerService customerService=new CustomerServiceImpl();
	
	@Override
	public void showMenuCustomer() {
		System.out.println("***** Registration/Login *****");
		System.out.println("____________________________________\n");
		System.out.println("1. Enter your details for Registration ");
		System.out.println("2. Enter you details for Login");
		System.out.println("3. Exit");
		System.out.println("_____________________________________\n");
		
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
			
			
			boolean isAdded = customerService.addCustomer(customer);
			
			if(isAdded)
				System.out.println("Registration Successful !!! \n");
			else 
				System.out.println("Something Went Wrong ...\n");
			
			break;

		
			
		case 2:
			Customer loginCustomer = new Customer();

			System.out.println("Enter Your UserName");
			loginCustomer.setUserName(sc.next());
			
			System.out.println("Enter Your Password");
			loginCustomer.setUserPassword(sc.next());
					
			boolean isVerified = customerService.validateCustomer(loginCustomer);
			
			if(isVerified) {
				System.out.println("LOGIN SUCCESSFULL !!!\n");
				while(true) {
					System.out.println("************ Main Menu *************");
					itemsPresentation.showMenu(loginCustomer.getUserName());
					System.out.println("Enter Your Choice ");
					int ch=sc.nextInt();
					itemsPresentation.performMenu(ch,loginCustomer.getUserName());
				}
			}
				
			else 
				System.out.println("SOMETHING WENT WRONG .. \n");

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
