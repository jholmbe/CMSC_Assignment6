/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: Ordering class for BevShop 
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>
{
	final int MIN = 10000;
	final int MAX = 90000;
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer orderCustomer;
	ArrayList<Beverage> bevList;
	
	//constructor
	public Order(int time, Day day, Customer customer) {
		this.orderNum = generateOrder();
		this.orderTime = time;
		this.orderDay = day;
		this.orderCustomer = customer;
		this.bevList = new ArrayList<Beverage>();
	}
	
	//generating order method using random value
	public int generateOrder() {
		int num = 0;		
		Random rand = new Random(MIN);
		num = rand.nextInt(MAX - MIN) + 1;
		return num;
	}
	
	//getters
	public int getOrderNo()
	{
		return this.orderNum;
	}
	
	public int getOrderTime()
	{
		return this.orderTime;
	}
	
	public Day getOrderDay()
	{
		return this.orderDay;
	}
	
	public Customer getCustomer()
	{
		return new Customer(orderCustomer);
	}
	
	public int getTotalItems()
	{
		return this.bevList.size();
	}
	
	//checks if the weekend
	@Override
	public boolean isWeekend() {
		boolean endOfWeek = false;
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			endOfWeek = true;
		}
		return endOfWeek;
	}
	
	//adding beverage methods for subclasses
	@Override
	public Beverage getBeverage(int itemNo)
	{
		return bevList.get(itemNo);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, isWeekend());
		bevList.add(alcohol);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		bevList.add(smoothie);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		this.bevList.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	
	@Override
	public double calcOrderTotal() 
	{
		double orderTotal = 0.0;
		for(int i = 0; i < bevList.size(); i++)
		{
			orderTotal += bevList.get(i).calcPrice();
		}
		return orderTotal;
	}
	
	//using for loop to determine which type each element is
	@Override
	public int findNumOfBeveType(Type type)
	{
		int bevNum = 0;
		for(int i = 0; i < bevList.size(); i++)
		{
			if(bevList.get(i).getType() == type)
			{
				bevNum++;
			}
		}
		return bevNum;
	}
	//returns number, time, day, customer name, age, list of bev
	public String toString()
	{
		String str = getOrderNo() + ", " + getOrderTime() + ", " + getOrderDay() + ", " +
				getCustomer().getName() + ", " + getCustomer().getAge() + "\n";
		
		for(int i = 0; i < bevList.size(); i++)
		{
			str += bevList.get(i) + "\n";
		}
		str += "$" + this.calcOrderTotal(); 

		return str;
		
	}
	
	@Override
	public int compareTo(Order anotherOrder)
	{
		if(this.getOrderNo() == anotherOrder.getOrderNo())
		{
			return 0;
		}
		else if(this.getOrderNo() > anotherOrder.getOrderNo())
		{
			return 1;
		}
		else {
			return -1;
		}
	}
}