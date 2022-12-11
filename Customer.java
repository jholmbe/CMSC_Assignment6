/* CMSC203 Assignment 6
Class: CMSC203 CRN 23999 
Program: Assignment 6 
Instructor: Farnaz Eivazi 
Description: This is a customer class for the beverage shop program
Due Date: 12/11/2022 
Integrity Pledge: I pledge that I have completed the programming assignment independently. 
I have not copied the code from a student or any source. 
Name: Justin Holmberg
*/
public class Customer {

	private String name;
	private int age;
	
	public Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c)
	{
		this.name = c.getName();
		this.age = c.getAge();
	}
	
	@Override
	public String toString()
	{
		return name + ", " + age + " years old";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}