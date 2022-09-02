package com.xyzretail.client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.xyzretail.config.JdbcConfiguration;
import com.xyzretail.presentation.CustomerPresentation;
import com.xyzretail.presentation.CustomerPresentationImpl;

public class Customer {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext=new AnnotationConfigApplicationContext(JdbcConfiguration.class);
		CustomerPresentation customerPresentation=(CustomerPresentationImpl)appContext.getBean("customerPresentationImpl");
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
