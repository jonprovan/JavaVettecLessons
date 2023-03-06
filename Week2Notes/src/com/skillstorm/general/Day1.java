package com.skillstorm.general;

import java.util.Scanner;

// Methods
public class Day1 {

	// this method has two parameters
	public static void printNumbers(double x, int y) {
		// x and y are local to this method
		// they only exist in this method
		System.out.println(x + y);
		
		x = 18.5;
		y = 7;
		
		System.out.println(x + y);
	}
	
	// this is a method
	// this method is the entry point every application
	// methods need to exist inside of a class
	// anything that stems from main runs, if main does not lead to it, it does not run
	public static void main(String[] args) {
		print("Hello World");
		//String message = "Hello world";
		//System.out.println(message);
		
		System.out.println("We're calling methods today");
		System.out.println("This is a method, this is the print method");
		
		// to call the method I need the signature and any parameters
		print("Not the tabs!");
		//message = "Not the tabs!";
		//System.out.println(message);
		
		// this version of x and y only exist inside the main method
		int y = 23;
		double x = 34.7;
		
		printNumbers(26.5, 12); // this is where i hand it the arguments
		//x = 26.5;
		//y = 23;
		//System.out.println(x + y);
		
		//x = 18.5;
		//y = 7;
		
		//System.out.println(x + y);
		//printNumbers(12, 26.5); // the order of the arguments has to match the order of the parameters
		
		printNumbers(x, y);
		//x = 34.7;
		//y = 23;
		//System.out.println(x + y);
		
		//x = 18.5;
		//y = 7;
		
		//System.out.println(x + y);
		
		doMath(); // will always print 24, as I have it setup
		
		// when i call a method, i dont need to do anything with the returned value
		longEquation(66, 36, 7.7);
		
		// if i want to do something with the return I need to save it somewhere
		System.out.println("Method return: " + longEquation(66, 36, 7.7));
		
		// different from result in the method
		double result = longEquation(66, 36, 7.7);
		System.out.println("result is: " + result);
		
		System.out.println(x);
		System.out.println(y);
		
		// incase i want to use the return later I save it to a variable
		String output = toppingRating();
		
		System.out.println(output);
		
		System.out.println(numComparison(7, 10));
		
		System.out.println(numComparison(longEquation(2, 3, 4.5), longEquation(2, 4, 1.1)));
	}
	
	public static String numComparison(double num1, double num2) {
		
		// every possible path must return a value
		if (num1 == num2) {
			return num1 + " is equal to " + num2;
		} else if (num1 > num2) {
			return num1 + " is greater than " + num2;
		} else {
			return num1 + " is less than " + num2;
		}
	}
	
	public static String toppingRating() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("What topping should I get?: ");
		String topping = in.nextLine();
		
		in.close();
		
		// can call any other methods within this method, same as before
		doMath();
		
		print("Processing your topping....");
		
		// my code must return a String no matter what,
		// So i need to make sure I have an else or something that 
		// happens after the if
		if (topping.equalsIgnoreCase("Pepperoni") ||
			topping.equalsIgnoreCase("Pineapple") ||
			topping.equalsIgnoreCase("Chicken")) {
			return "Great Choice!"; // if this is hit, method ends here
			
		} else if (topping.equalsIgnoreCase("Anchovies")) {
			return "Ewww"; // if this is hit, method ends here
		} 
		
		// if none of the above is true, this is returned
		return "Good Choice";
		
		//System.out.println("This will never run");
		//cannot put any code after a return
	}
	
	public static double longEquation(int a, int b, double c) { // method declaration
		double result = 0;
		
		// I don't want to retype all of this. so I made it a method
		// I can reuse this code as much as I want by calling the method signature
		// and changing the arguments
		double out1 = Math.pow(a, 3) + b * Math.pow(c + b, 2) - a * c;
		double out2 = a % c * (Math.pow(a, c) / b) + c;
		double out3 = Math.pow(b, 3) * a * Math.sqrt(Math.pow(c / b, 2)) - a + c;
		
		result = (out1 + out2) / out3;
		
		// return keyword is used to tell a method to give a value back to
		// whatever called this method
		// the value must match the return type in the method declaration
		return result;
	}
	
	// methods can have no parameters
	public static void doMath() {
		int num1 = 47;
		int num2 = 23;
		
		System.out.println(num1 - num2);
	}
	
	// the order of defining/declaring these does not matter
	// this method has 1 parameter
	public static void print(String message) {
		// public = accessor/ access modifier
		// static = modifier
		// void = return type
		// print = method name (part of the signature)
		// (String message) = parameter (other part of the signature)
		// {} = method body
		
		// methods can call other methods
		System.out.println(message);
	}
}
