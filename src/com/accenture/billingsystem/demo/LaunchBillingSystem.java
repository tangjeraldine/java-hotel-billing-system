package com.accenture.billingsystem.demo;

import java.util.ArrayList;
import java.util.Scanner;

public class LaunchBillingSystem {

	public static void main(String[] args) {
		int itemID=0;
		int quantity=0; 
		String itemName=null;
		int itemPrice=0;
		int subTotal=0;
		int grandTotal=0;
		String choice ="y";
		
		ArrayList<Bill> newItem = new ArrayList<Bill>();
		
		System.out.println("Dear customer, welcome to xyz hotel");
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your name");
		String name = scan.nextLine();
		
		while (choice.equals("y")) {
		System.out.println("Dear "+name+", below is the menu");
		System.out.println("----------------------------------");
		System.out.println("ItemID     ItemName     ItemPrice");
		System.out.println("----------------------------------");
		System.out.println("1          Water         10");
		System.out.println("2          Pepsi         25");
		System.out.println("3          Pizza         50");
		System.out.println("4          Fries         35");
		System.out.println("5          Burger        60");
		System.out.println("----------------------------------");
		
		System.out.println("Enter the Item ID");
		itemID = scan.nextInt();
		
		System.out.println("Enter the quantity");
		quantity = scan.nextInt();
		
		switch(itemID) {
		case 1: itemName="Water";
				itemPrice = 10;
				subTotal = itemPrice*quantity;
				break;
		case 2: itemName="Pepsi";
				itemPrice = 25;
				subTotal = itemPrice*quantity;
				break;
		case 3: itemName="Pizza";
				itemPrice = 50;
				subTotal = itemPrice*quantity;
				break;
		case 4: itemName="Fries";
				itemPrice = 35;
				subTotal = itemPrice*quantity;
				break;
		case 5: itemName="Burger";
				itemPrice = 60;
				subTotal = itemPrice*quantity;
				break;
		default: System.out.println("Invalid selection");
				break;
		}
		System.out.println("item name: "+itemName+"     item price: "+itemPrice+"    quantity: "+quantity+"    subtotal: "+subTotal);
		grandTotal += subTotal;
//		Bill b = new Bill(itemName, itemPrice, quantity, subTotal);
//		newItem.add(b);
		newItem.add(new Bill(itemName, itemPrice, quantity, subTotal));
		System.out.println("Do you want to order more? (y/n)");
		choice = scan.next();
		} 
if (choice.equals("n")) {
			System.out.println("--------------------------------------------");
			System.out.println("ItemName  ItemPrice  Quantity   Subtotal");
			System.out.println("--------------------------------------------");
		// for each loop
		for (Bill x:newItem) {
			System.out.println(x);
		}
		System.out.println("--------------------------------------------");
		System.out.println("Total bill is: "+grandTotal);
		System.out.println("--------------------------------------------");
	}}

}

class Bill {
	String itemName;
	int itemPrice;
	int quantity;
	int subTotal;
	//source --> Generate constructor using Fields
	public Bill(String itemName, int itemPrice, int quantity, int subTotal) {
		super();
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	
	@Override
	public String toString() {
		return itemName+"        "+itemPrice+"         "+quantity+"        "+subTotal;
	}
	
	
}
