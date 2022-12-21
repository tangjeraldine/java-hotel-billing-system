import java.util.ArrayList;
import java.util.Scanner;

class Welcome {
	String name;
	int orderItem;
	int quantity;
	int Subtotal;
	int Total;
	int Tip;
	float GST;
	int[] price = {10, 25, 50, 35, 60};
	String[] itemName = {"Water", "Pepsi", "Pizza", "Fries", "Burger"};
	ArrayList<String> itemNameList = new ArrayList<String>();
	ArrayList<Integer> itemPriceList = new ArrayList<Integer>();
	ArrayList<Integer> quantityList = new ArrayList<Integer>();
	ArrayList<Integer> subtotalList = new ArrayList<Integer>();
	
	void WelcomeMsg() {
		System.out.println("Welcome to the hotel!");
		System.out.println("Dear customer, please enter your name");
		Scanner custName = new Scanner(System.in);
		name = custName.next();
		System.out.println("Dear "+name+", below is the menu");
	}
	void Menu() {
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
		Scanner itemID = new Scanner(System.in);
		orderItem = itemID.nextInt();
		System.out.println("Enter the quantity");
		Scanner q = new Scanner(System.in);
		quantity = q.nextInt();
	}
	
	void SubTotal() {
		Subtotal = price[orderItem-1]*quantity;
		subtotalList.add(Subtotal);
		Total += Subtotal;
		itemNameList.add(itemName[orderItem-1]);
		System.out.println("Item name: "+itemName[orderItem-1]);
		itemPriceList.add(price[orderItem-1]);
		System.out.println("Item price: "+price[orderItem-1]);
		quantityList.add(quantity);
		System.out.println("Quantity: "+quantity);
		System.out.println("Subtotal: "+Subtotal);
	}
	
	void amendOrder() {
		
		Scanner a = new Scanner(System.in);
		System.out.println("Would you like to amend your order? (Y/N)");
		String amend = a.next();
		if (amend.equals("Y")) {
			System.out.println("-----------------------------------------------------");
			System.out.println("ItemName  ItemPrice  Quantity   Subtotal");
			System.out.println("-----------------------------------------------------");
			for (int i=0; i<itemNameList.size(); i++) {
				System.out.println(itemNameList.get(i)+"    "+itemPriceList.get(i)+"    "+quantityList.get(i)+"    "+subtotalList.get(i));
			}
			System.out.println("-----------------------------------------------------");
		} 
	}
	
	void finalBill() {
		System.out.println("-----------------------------------------------------");
		System.out.println("ItemName  ItemPrice  Quantity   Subtotal");
		System.out.println("-----------------------------------------------------");
		for (int i=0; i<itemNameList.size(); i++) {
			System.out.println(itemNameList.get(i)+"    "+itemPriceList.get(i)+"    "+quantityList.get(i)+"    "+subtotalList.get(i));
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("Dear "+name+", your bill amount is: "+Total);
		System.out.println("Please enter the tip");
		Scanner t = new Scanner(System.in);
		Tip = t.nextInt();
		GST = Total*0.08f;
		System.out.println("GST: "+GST);
		System.out.println("The total amount payable is: "+(Total+GST+Tip));
	}
	
}

public class LaunchBillingSystem {

	public static void main(String[] args) {
		Welcome w = new Welcome();

		w.WelcomeMsg();
		w.Menu();
		w.SubTotal();
		
		Scanner ans = new Scanner(System.in);
		System.out.println("Would you like to order more? (Y/N)");
		String A = ans.next();
		while (A.equals("Y")) {
			w.Menu();
			w.SubTotal();
			System.out.println("Would you like to order more? (Y/N)");
			A = ans.next();
		}
		while (A.equals("N")) {
			w.finalBill();
			break;
		}
		
		} 
	}

