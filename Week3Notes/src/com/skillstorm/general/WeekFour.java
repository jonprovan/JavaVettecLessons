package com.skillstorm.general;

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
		
		exceptions();
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
