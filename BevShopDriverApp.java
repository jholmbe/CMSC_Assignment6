/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: Driver class
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public class BevShopDriverApp {
	
	public static void main(String[] args) {
		
		BevShop shop = new BevShop();
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Makima", 17);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Mocha and Kiwi Smoothie to order");
		shop.processCoffeeOrder("Mocha", Size.MEDIUM, false, false);
		shop.processSmoothieOrder("Kiwi Smoothie", Size.MEDIUM, 3, false);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Whiskey to order");
		shop.processAlcoholOrder("Whiskey", Size.MEDIUM);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Jojo", 25);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Whiskey, Wine, and Beer to order");
		shop.processAlcoholOrder("Whiskey", Size.MEDIUM);
		shop.processAlcoholOrder("Wine", Size.SMALL);
		shop.processAlcoholOrder("Beer", Size.LARGE);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Adding Vodka to order");
		shop.processAlcoholOrder("Vodka", Size.MEDIUM);
		System.out.println(shop.getCurrentOrder());
		System.out.println("Getting total order price");
		System.out.println(shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo()));
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Denji", 36);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println("Creating new order");
		shop.startNewOrder(22, Day.SUNDAY, "Gina", 57);
		System.out.println(shop.getCurrentOrder());
		System.out.println("");
		
		System.out.println(shop);
		shop.sortOrders();
		System.out.println(shop);
		
	}

}