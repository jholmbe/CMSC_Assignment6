/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: The main beverage shop class
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BevShop implements BevShopInterface
{
	private int numOfAlcoholInOrder;
	private int currentOrder;
	private ArrayList<Order> orders;

	
	public BevShop()
	{
		orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time)
	{
		if(time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits)
	{
		if(numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol()
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore()
	{
		if(numOfAlcoholInOrder< 3){
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public int getNumOfAlcoholDrink()
	{
		return this.numOfAlcoholInOrder;
	}

	@Override
	public boolean isValidAge(int age)
	{
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge)
	{
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrder = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
		numOfAlcoholInOrder++;
	}
	
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		orders.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	public int findOrder(int orderNo)
	{
		int index = -1;
		for(int i = 0; i < orders.size(); i++){
			if(orders.get(i).getOrderNo() == orderNo){
				index = i;
			}
		}
		return index;
	}

	
	@Override
	public double totalOrderPrice(int orderNo)
	{
		double orderTotal = 0.0;
		orderTotal = orders.get(findOrder(orderNo)).calcOrderTotal();
		return orderTotal;
	}

	@Override
	public double totalMonthlySale()
	{
		double monthTotal = 0.0;
		for(int i = 0; i < orders.size(); i++)
		{
			monthTotal += orders.get(i).calcOrderTotal();
		}
		return monthTotal;
	}

	@Override
	public int totalNumOfMonthlyOrders()
	{
		int monthOrderNum = orders.size();
		return monthOrderNum;
	}

	@Override
	public Order getCurrentOrder()
	{
		return orders.get(currentOrder);
	}

	@Override
	public Order getOrderAtIndex(int index)
	{
		Order orderIndex = orders.get(index);
		return orderIndex;
	}
	
	@Override
	public void sortOrders()
	{
		Collections.sort(this.orders, new Comparator<Order>() {
      	  @Override
      	  public int compare(Order o1, Order o2) {
      		  double orderNum1 = o1.getOrderNo();
      		  double orderNum2 = o2.getOrderNo();
      	    return (orderNum1 > orderNum2) ? 1 : ((orderNum1 < orderNum2) ? -1 : 0) ;
      	  }
      	});
	}
	
	public String toString()
	{
		String str = "Bradley Beverage Shop Month Report: \n";
		for(int i = 0; i < orders.size(); i++)
		{
			str += "Order: " + i + 1;
			str += "\nOrderNum: " + orders.get(i).getOrderNo();
			str += "\nCustomer: " + orders.get(i).getCustomer().getName();
			str += "\nOrder List: " + orders.get(i).toString();
		}
		str += "\n\nTotal Monthly Orders: " + this.totalNumOfMonthlyOrders();
		str += "\nTotal Month Sales: " + this.totalMonthlySale(); 
		return str;
	}

	
}