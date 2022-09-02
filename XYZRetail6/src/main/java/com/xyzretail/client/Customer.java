package com.xyzretail.client;

import java.util.Scanner;
import com.xyzretail.presentation.CustomerPresentation;
import com.xyzretail.presentation.CustomerPresentationImpl;



public class Customer {
	
	public static void main(String[] args) {
		CustomerPresentation customerPresentation=new CustomerPresentationImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("\n***********************************  Welcome to Our Shopping Basket Application !! ************************\n");
		while(true) {
			customerPresentation.showMenuCustomer();
			System.out.println("Enter Choice ");
			int choice=scanner.nextInt();
			customerPresentation.performMenuCustomer(choice);			
		}

	}
}
