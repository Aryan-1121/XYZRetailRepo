package com.xyzretail.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xyzretail.config.XyzConfiguration;
import com.xyzretail.presentation.CustomerPresentation;
import com.xyzretail.presentation.CustomerPresentationImpl;



public class Customer {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext springContainer = new AnnotationConfigApplicationContext(XyzConfiguration.class);
//		CustomerPresentation customerPresentation=new CustomerPresentationImpl();
		
		CustomerPresentation customerPresentation = (CustomerPresentation) springContainer.getBean("customerPresentation");
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
