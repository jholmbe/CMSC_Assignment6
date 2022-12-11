/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: This is an subclass for beverage objects, similar to the smoothie and alcohol classes
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double shotCost = 0.50;
	private final double syrupCost = 0.50;
	
	//constructor
	public Coffee(String bevName, Size size, boolean shot, boolean syrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraShot = shot;
		this.extraSyrup = syrup;
	}
	
	//getters
	public boolean getExtraShot()
	{
		return this.extraShot;
	}
	public boolean getExtraSyrup()
	{
		return this.extraSyrup;
	}
	
	//utilizing abstract beverage method
	public double calcPrice(){
		
		double price = this.addSizePrice();
		
		if(this.extraShot) {
			price += this.shotCost;
		}
		if(this.extraSyrup) {
			price += this.syrupCost;
		}
		return price;
	}
	
	//Override toString method
	public String toString()
	{
		String str = this.getBevName() + ", " + this.getSize();
		
		if(extraShot == true)
		{
			str += ", extra shot";
		}
		if(extraSyrup == true)
		{
			str += ", extra syrup";
		}
		str += ", $" + this.calcPrice();
		return str;
	}
	
	//Override equals method
	public boolean equals(Beverage bevObj)
	{
	
		if(bevObj instanceof Coffee && super.equals(bevObj)
				&& extraShot==((Coffee)bevObj).getExtraShot()&& extraSyrup==((Coffee)bevObj).getExtraSyrup())
		{
			return true;
		}
		return false;
	}
}