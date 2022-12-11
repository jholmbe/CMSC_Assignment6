/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: This is an subclass for beverage objects, similar to the coffee and alcohol classes
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	private final double fruitCost = 0.5;
	private final double proteinCost = 1.50;
	
	//constructor
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	//getters
	public int getNumOfFruits()
	{
		return this.numOfFruits;
	}

	public boolean getAddProtein()
	{
		return this.addProtein;
	}
	
	@Override
	public String toString()
	{
		String str = getBevName() + ", " + getSize() + ", " + numOfFruits + "fruits";
		
		if(addProtein)
		{
			str += ", protein powder";
		}
		
		str += ", $" + calcPrice();
		return str;
	}
	
	//abstract method
	public double calcPrice(){
		double price = this.addSizePrice();
		if(this.addProtein) {
			price += this.proteinCost;
		}
		price += this.fruitCost * this.numOfFruits;
		return price;
	}
	
	@Override
	public boolean equals(Beverage bevObj)
	{
		boolean flag = false;
		if(super.equals(bevObj) && bevObj instanceof Beverage)
		{
			flag = true;
		}
		return flag;
	}
}

