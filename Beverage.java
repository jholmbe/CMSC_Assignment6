/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: This is an abstract class for beverage objects and subclasses like coffee, alcohol, and smoothie
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double basePrice = 2.0;
	private final double sizeUp = 1.0;
	
	//constructor for beverage class
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	//if size = x, price = y;
	abstract double calcPrice();
	
	//Override toString method
	public String toString() {
		return this.getBevName() + ", " + this.size;
	}
	
	//Override equals method
	public boolean equals(Beverage drink) {
		boolean flag = true;
		if (!(this.bevName.equalsIgnoreCase(drink.bevName))) {
			flag = false;
		}
		if (drink.type != this.type) {
			flag = false;
		}
		if (drink.size != this.size) {
			flag = false;
		}
		return flag;
	}
	//setter methods
	public void setName(String name) {
		this.bevName = name;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	//getter methods
	public String getBevName() {
		return this.bevName;
	}
	public Type getType() {
		return this.type;
	}
	public Size getSize() {
		return this.size;
	}
	public double getBasePrice()
	{
		return this.basePrice;
	}
	//size pricing
	public double getSizeUpPrice()
	{
		return sizeUp;
	}
	public double addSizePrice() {
		if(getSize() == Size.MEDIUM){
			return basePrice + sizeUp;
		}else if(getSize() == Size.LARGE) {
			return basePrice + sizeUp*2;
		}
		return basePrice;
	}
}
