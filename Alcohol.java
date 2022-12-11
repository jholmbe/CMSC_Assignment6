/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: This is an subclass for beverage objects, similar to the smoothie and coffee classes
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public class Alcohol extends Beverage{
	private boolean isWeekend;
	private final double weekendCost = 0.60;
	
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	@Override
	public double calcPrice(){
		if(this.isWeekend()) {
			return this.addSizePrice() + this.weekendCost;
		}
		return this.addSizePrice();
	}
	
	@Override
	public String toString()
	{
		String str = getBevName() + ", " + getSize();
		if(isWeekend) {
			str += ", weekend";
		}
		str += ", $" + calcPrice();
		return str;
	}
	
	@Override
	public boolean equals(Beverage anotherBev)
	{
		//a = new Alcohol(getBevName(), getSize(), isWeekEnd);
		if(anotherBev instanceof Alcohol && super.equals(anotherBev))
		{
			 return true;
		}
		return false;
	}
	public boolean isWeekend()
	{
		return isWeekend;
	}
}
