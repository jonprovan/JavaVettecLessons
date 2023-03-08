package com.skillstorm.general;

import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		// arrays are a collection of anything
		// all items need to have the same data type
		
		// can define an array with an array literal
		// declares and initializes the array
		String[] cookies = { "Chocolate Chip", "Oatmeal", "Sugar", "Snickerdoodle" };
		
		System.out.println(cookies.length);
		System.out.println(cookies); // cannot print the array like this
		// just prints the memory location
		
		System.out.println(cookies.toString()); // also does not help
		
		System.out.println(cookies[0]);
		System.out.println(cookies[1]);
		System.out.println(cookies[2]);
		System.out.println(cookies[3]);
		
		// declares and initializes the array
		String[] cars = new String[5];
		System.out.println(cars[0]); // no value, default is null
		System.out.println(cars[1]);
		System.out.println(cars[2]);
		System.out.println(cars[3]);
		System.out.println(cars[4]);
		
		cars[0] = "BMW 335i";
		cars[1] = "Nissan Altima";
		cars[2] = "VW Rabbit";
		cars[3] = "Ford Festiva";
		cars[4] = "Tesla Plaid";
		
		System.out.println(cars[0]);
		System.out.println(cars[1]);
		System.out.println(cars[2]);
		System.out.println(cars[3]);
		System.out.println(cars[4]);
		
		int[] nums; // declares and array
		
		//nums[0] = 27; // cant do this, hasnt been initialized
		
		// initializes the array
		nums = new int[] { 23, 7, 13, 4, 15, 67, 42, 72, 45, 81 };
		
		System.out.println(nums[4]);
		System.out.println(nums[5]);
		System.out.println(nums[7]);
		
		int a = nums[4];
		int b = nums[5];
		int c = nums[7];
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		nums[4] = 65;
		nums[5] = 89;
		nums[7] = 17;
		
		System.out.println(nums[4]);
		System.out.println(nums[5]);
		System.out.println(nums[7]);
		// a, b, and c will be unchanged
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		// .length has no () because it is a property, not a method
		System.out.println(nums.length);
		
		String name = "Miles Mixon";
		System.out.println(name.length());
		
		// Strings can easily be converted to char arrays, they are char arrays
		char[] name2 = name.toCharArray(); 
		System.out.println(name2[0]);
		System.out.println(name2[1]);
		System.out.println(name2[2]);
		System.out.println(name2[3]);
		System.out.println(name2[4]);
		
		String firstName = new String(name2);
		System.out.println(firstName);
		
		//String[] myCars = getGarageSpace();
		
		//System.out.println(myCars.length);
		
		System.out.println("First 3 = " + count3(nums));
		
		int[] numArray1 = { 1, 2, 3};
		int[] numArray2 = numArray1;
		
		System.out.println("****** Number arrays ******");
		System.out.println("NumArray1: ");
		System.out.println(numArray1[0]);
		System.out.println(numArray1[1]);
		System.out.println(numArray1[2]);
		
		System.out.println("NumArray2: ");
		System.out.println(numArray2[0]);
		System.out.println(numArray2[1]);
		System.out.println(numArray2[2]);
		
		// actually changes both
		numArray1[1] = 5;
		
		System.out.println("NumArray1: ");
		System.out.println(numArray1[0]);
		System.out.println(numArray1[1]);
		System.out.println(numArray1[2]);
		
		System.out.println("NumArray2: ");
		System.out.println(numArray2[0]);
		System.out.println(numArray2[1]);
		System.out.println(numArray2[2]);
		
		System.out.println(numArray1);
		System.out.println(numArray2);
		
		numArray1 = new int[3];
		
		System.out.println("NumArray1: ");
		System.out.println(numArray1[0]);
		System.out.println(numArray1[1]);
		System.out.println(numArray1[2]);
		
		System.out.println("NumArray2: ");
		System.out.println(numArray2[0]);
		System.out.println(numArray2[1]);
		System.out.println(numArray2[2]);
		
		System.out.println(numArray1);
		System.out.println(numArray2);
		
		// one way to make a copy of an array
		numArray1 = numArray2.clone();
		
		System.out.println("***** Clone ******");
		System.out.println("NumArray1: ");
		System.out.println(numArray1[0]);
		System.out.println(numArray1[1]);
		System.out.println(numArray1[2]);
		
		System.out.println("NumArray2: ");
		System.out.println(numArray2[0]);
		System.out.println(numArray2[1]);
		System.out.println(numArray2[2]);
		
		numArray2[0] = 7;
		
		System.out.println("NumArray1: ");
		System.out.println(numArray1[0]);
		System.out.println(numArray1[1]);
		System.out.println(numArray1[2]);
		
		System.out.println("NumArray2: ");
		System.out.println(numArray2[0]);
		System.out.println(numArray2[1]);
		System.out.println(numArray2[2]);
		
		System.out.println(numArray1);
		System.out.println(numArray2);
		
		//System.out.println(numArray1[5]);
	}
	
	public static int count3(int[] nums) {
		int result = 0;
		
		result = result + nums[0]; // 0 + 23
		result = result + nums[1]; // 23 + 7
		result = result + nums[2]; // 30 + 13
		
		return result;
	}
	
	// can return string arrays from methods, I can return any valid type from a method
	// or void if it returns nothing
	public static String[] getGarageSpace() {
		String[] garage; // declared, but not initialized
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many cars do you have?: ");
		int current = in.nextInt(); // read in the number of cars
		in.nextLine(); // clears the buffer
		
		System.out.println("How many cars do you want?: ");
		int desired = in.nextInt(); // read in the number of cars
		in.nextLine(); // clears the buffer
		
		in.close();
		System.out.println("Searching.....");
		System.out.println("You're in luck! I've got just the thing for you!");
		
		garage = new String[desired]; // initializes garage to be what the user entered
		
		return garage;
	}
}
