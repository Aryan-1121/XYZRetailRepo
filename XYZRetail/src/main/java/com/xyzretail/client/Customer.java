package com.xyzretail.client;

import java.util.Scanner;

import com.xyzretail.presentation.ItemsPresentation;
import com.xyzretail.presentation.ItemsPresentationImpl;


public class Customer {
	
	public static void main(String[] args) {
		ItemsPresentation itemsPresentation=new ItemsPresentationImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			itemsPresentation.showMenu();
			System.out.println("Enter Choice ");
			int choice=scanner.nextInt();
			itemsPresentation.performMenu(choice);
					
		}

	}
}
