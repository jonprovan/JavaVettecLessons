package com.skillstorm.general;

import java.io.IOException;
import java.util.Random;

import com.skillstorm.beans.GrandTouring;
import com.skillstorm.beans.Motorcycle;
import com.skillstorm.beans.Sport;

public class WeekFour {

	public static void main(String[] args) {
		// we're going to start with objects in memory
		Sport bike = new Sport("Suzuki", "Hayabusa", "Blue", 200, "Medium", true);
		// inside the main method I can change the properties of an object by calling a
		// getter/ setter
		System.out.println(bike);
		bike.setColor("Red");
		System.out.println(bike);
		
		int x = 37;
		
		System.out.println(x);
		x = 42;
		
		System.out.println(x);
		
		// passes the value of x, not x
		changeX(x);
		
		System.out.println(x);
		
		// this changes the original value
		// has a copy of the memory address
		changeBike(bike);
		
		System.out.println(bike);
		
		// this does not change the original bike at all
		// makes a completely new one
		changeBike2(bike);
		
		// the original bike is untouched
		System.out.println(bike);
		
		// stack overflow error
		// dont do this, it will kill your program every time
		//callMe();
		
		//randomization();
		
		//exceptions();
		failGracefully();
	}
	
	public static void failGracefully() {
		// when running your code you want to fail gracefully
		// your stack trace actually gives potential bad actors important information
		// about your code
		// luckily exceptions can be recovered from
		
		// you can try-catch statement to handle exceptions
		// you wrap your risky code inside the try { } and then your error
		// handling code inside the catch() { } you NEED a catch for every try		
		
		//int otherResult = 5 / 0; // only the code inside of a try is protected
		
		try {
			// try to run this
			int var = 0;
			int result = 5 / var; // ArithmeticException
			System.out.println("Math works"); // this will not run if an exception is thrown
		} catch(ArithmeticException ex) {
			// if the code above didnt work because of an arithmetic exception run this
			// need to tell the catch what to look for
			System.out.println("Someone mathed wrong here");
		}
		
		// scoping applies for a try-catch in the same way it does for an if-else or any
		// loop we've gone through
		try {
			int[] nums = { 2, 4, 6, 1 }; // only exists inside the try
			nums[5] = 7;
			System.out.println("updated successfully");
		} catch (ArrayIndexOutOfBoundsException ex) {
			// if the code above didnt work because of an ArrayIndexOutOfBoundsException run this
			//nums[2] = 3; // nums doesnt exist here
			System.out.println("That was outside the array");
		}

		// you can look for multiple exceptions
		try {
			int val = 0;
			int[] vals = { 1, 2 };
			Sport obj = null;
			
			//vals[Integer.parseInt((String)obj)] = 3 / val; // NumberFormatException
			//obj.doWheelie(); // NullPointerException
			int result = 3 / vals[3]; // ArrayIndexOutOfBoundsException
			
		} catch (ArithmeticException ex) {
			ex.printStackTrace(); // i can use this to have the exception tell me what happened
			System.out.println("Arithmetic");
		} catch (ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
			
			// if some exception happens in a catch statement, it still crashes your code
			//throw new IndexOutOfBoundsException();
			System.out.println("Array Index");
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("null pointer");
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Number format");
		} catch (Exception ex) {
			// this is a catch all basically. it needs to be last,
			// if it is not last it creates unreachable code
			// the order of the catches matters
			System.out.println("Catches everything");
		} 
		
		// every exception in Java comes form the Exception class
		try {
			int val = 0;
			int[] vals = { 1, 2 };
			Sport obj = null;
			
			//vals[Integer.parseInt(obj.toString())] = 3 / val; // NumberFormatException
			//obj.doWheelie(); // NullPointerException
			int result = 3 / vals[3]; // ArrayIndexOutOfBoundsException
		} catch(Exception ex) {
			// i cant get very specific without knowing what the exception is
			System.out.println("Will always catch an exception");
		}
		
		//moreExceptions();
		
		try {
			moreExceptions2();
			System.out.println("My code worked!");
		} catch (IOException ex) {
			// need to catch an IO exception because that is what I said the method throws
			System.out.println("My IO Exception: ");
			ex.printStackTrace();
		} catch (CloneNotSupportedException ex) {
			System.out.println("My clone not supported exception: ");
			ex.printStackTrace();
		} catch(ImATeapotException ex) {
			System.out.println("This is a teapot...");
			ex.printStackTrace();
		} finally {
			// you can only have one finally block, and it always runs
			// any code that needs to happen regardless of if you run successfully or not
			System.out.println("This runs regardless of what happens");
		}
		
		// all of the above exceptions are runtime exceptions
		// Java does not know if these occur until your code runs
		System.out.println("Method finished");
	}
	
	// throws keyword is used to signal other developers that I throw an exception
	// this creates a checked exception
	// anything that isnt an error or a runtime exception is checked
	// can list out multiple exceptions as being thrown by your method
	public static void moreExceptions2() 
			throws IOException, CloneNotSupportedException, ImATeapotException {
		// I can only use the throw keyword with Throwables
		// Throwable is the parent class of Error and Exception
		throw new ImATeapotException(); //  throw says I want an exception to be thrown
	}
	
	// errors and runtime exceptions are always unchecked
	public static void moreExceptions() {
		// the throw keyword is used to throw an exception
		// even though i wrote this line, Java has no idea it's going to crash
		// Errors and RuntimeExceptions are unchecked exceptions
		// Java doesnt look for them and doesnt make sure you know how to handle them
		throw new IndexOutOfBoundsException(); // RuntimeException
	}
	
	public static void exceptions() {
		// exceptions
		// some unforseen thing happened, something Java does not know how to
		// recover from. These happen at runtime/ compile time
		// you can recover from exceptions, but you need to tell Java how
		// exceptions you can recover from
		// errors you cannot
		int var = 0;
		int result = 5/var; // ArithmeticException
		
		// exceptions give you a stack trace
		// this lets you retrace your steps through the call stack
		
		int[] nums = { 2, 3, 5, 6 };
		nums[5] = 7; // ArrayIndexOutOfBoundException
		
		Sport bike = null;
		bike.setBrand("Ducati"); // NullPointerException
		
		Motorcycle bike2 = new Sport("Ducati", "Monster", "Red", 100, "Small", false);
		// there is a chance any Motorcycle is a GrandTouring because GrandTourings are
		// Motorcycles
		GrandTouring bike3 = (GrandTouring)bike2; // ClassCastException
		
		// the above exceptions are a part of the java.lang package
		// the above are all examples of runtime exceptions
		// runtime exceptions are exceptions that happen when your code runs
		
		// every exception stops your code from completing properly
		// as is, this line is never reached
		System.out.println("Method finished");
	}
	
	public static void randomization() {
		// Java only has pseudo-random values
		// computers are math, and math is not random
		// pseudo-random is effectively random
		// Java has two ways to do this
		
		//You have the Math class
		//and the Random class. The Random is preferred 
		System.out.println("***** Math.random ******");
		for (int i = 0; i < 10; i++) {
			// Math.random() always returns a double
			System.out.println(Math.random());
			// will always return a decimal value between 0.0 and 1.0
		}
		
		System.out.println("***** Math.random with range ******");
		// if you want larger values, you have to do math
		for (int i = 0; i < 10; i++) {
			// Math.random() * (high - low) + low
			System.out.println(Math.random() * (120 - 30) + 30);
		}
		
		System.out.println("***** Random next int ******");
		// the second, and more preferred way to get a random value is 
		// the Random class
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(rand.nextInt());
		}
		
		System.out.println("***** Random next int with range ******");
		for (int i = 0; i < 10; i++) {
			// random.nextInt(high + 1 - low) + low
			// not inclusive of the high value for ints
			System.out.println(rand.nextInt(121 - 115) + 115);
		}
		
		System.out.println("***** Random next double with range ******");
		for (int i = 0; i < 10; i++) {
			// random.nextDouble() * (high - low) + low
			System.out.println(rand.nextDouble() * (120 - 110) + 110);
		}
		
		// The random values here are based on the seed, the values are not random
		// the randomness comes from the seed. By default it uses the system time
		// but you can set the seed as a parameter in the constructor
		// Random rand = new Random(1);
		// in the above, 1 is the seed
	}
	
	public static void callMe() {
		callMe();
	}
	
	// val only exists inside this method, after the method ends
	// val is deleted. primitives are pass by value
	public static void changeX(int val) {
		System.out.println(val);
		
		val = 46;
		
		System.out.println(val);
	}
	
	// objects can be changed inside methods
	// objects are pass by reference technically
	public static void changeBike(Sport bike) {
		System.out.println(bike);
		
		bike.setColor("Green");
		
		System.out.println(bike);
	}
	
	// this does not change the original object
	public static void changeBike2(Sport bike) {
		// i have a copy of the memory address of bike from main
		System.out.println(bike); // here i'm looking at the bike from main
		
		// i tell that copy to look at a different memory address
		bike = new Sport("Honda", "CTX12000", "Purple", 230, "Small", true);
		
		// now the local variable bike is looking at the new address
		System.out.println(bike);
	}
}
