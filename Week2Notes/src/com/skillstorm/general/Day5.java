package com.skillstorm.general;

import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) {
		// while loop
		int count = 0;
		
		System.out.println("***** While loop *****");
		while (count < 3) {
			System.out.println(count);
			count++;
		}
		
		System.out.println();
		
		// do while loop
		int a = 0;
		
		System.out.println("***** Do While loop *****");
		do {
			System.out.println(a);
			a++;
		} while (a < 3);
		
		System.out.println();
		
		// for loop
		System.out.println("***** for loop *****");
		
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}
		
		System.out.println();
		
		// foreach loop (enhanced for loop)
		// need an array, because foreach loops can only loop over a collection
		int[] nums = { 0, 1, 2 };
		
		System.out.println("***** foreach loop *****");
		
		for (int num : nums) {
			System.out.println(num);
		}
		
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		//carPrompt(in);
		
		//shorterCarPrompt(in);
		
		//icecream();
		
		foreachIceCream();
		
		in.close();
	}
	
	public static void foreachIceCream() {
		String[] flavors = { "Vanilla", 
							 "Chocolate", 
							 "Mint", 
							 "Cookie Dough", 
							 "Strawberry",
							 "Rum Raisin",
							 "Salted Caramel" };
		
		String[] toppings = { "M&Ms", 
							  "Chocolate Chips",
							  "Oreos",
							  "Kit Kats",
							  "Sprinkles",
							  "Chocolate Syrup",
							  "Caramel",
							  "Strawberry",
							  "Reese's",
							  "Whipped Cream" };
		
		System.out.println("***** Ice Cream *****");
		// no indexes, executes once for every value in the array
		for (String flavor : flavors) {
			for (String topping : toppings) {
				String bowl = flavor + " and " + topping;
				
				System.out.println(bowl);
			}
		}
	}
		
	public static void icecream() {
		String[] flavors = { "Vanilla", 
							 "Chocolate", 
							 "Mint", 
							 "Cookie Dough", 
							 "Strawberry",
							 "Rum Raisin",
							 "Salted Caramel" };
		
		System.out.println("***** Ice Cream *****");
//		for (int i = 0; i < flavors.length; i++) {
//			System.out.println(flavors[i]);
//		}
		
		// no difference in my output as above
//		System.out.println("***** Ice Cream *****");
//		for (int i = 0; i < flavors.length; ++i) {
//			System.out.println(flavors[i]);
//		}
		
		// everything, except the semi-colons and the () is optional in a 
		// for loop
		// i only exists inside the loop, that's why im able to re-use it here
//		System.out.println("***** Ice Cream *****");
//		for (int i = 0; i < flavors.length;) {
//			System.out.println(flavors[i]);
//			++i;
//		}
		
//		int j = 0;
//		System.out.println("***** Ice Cream *****");
//		for (; j < flavors.length;) {
//			System.out.println(flavors[j]);
//			j++;
//		}
		
//		int j = 0;
//		System.out.println("***** Ice Cream *****");
		// for (;;) is an infinite loop
		// there is no condition to tell it when to stop, so it doesnt
//		for (;;) {
//			if (!(j < flavors.length)) {
//				break;
//			}
//			System.out.println(flavors[j]);
//			j++;
//		}
		
		String[] toppings = { "M&Ms", 
							  "Chocolate Chips",
							  "Oreos",
							  "Kit Kats",
							  "Sprinkles",
							  "Chocolate Syrup",
							  "Caramel",
							  "Strawberry",
							  "Reese's",
							  "Whipped Cream" };
		
		for (int i = 0; i < flavors.length; i++) {
			//String bowl = flavors[i] + " and ";
			
			// can nest loops just like if statements
			// will do all iterations of the inner loop, before circling
			// back around to the outer loop
			for (int j = 0; j < toppings.length; j++) {
				String bowl = flavors[i] + " and " + toppings[j];
//				if (j == 0) {
//					bowl += toppings[j];
//				} else {
//					bowl += ", " + toppings[j];
//				}
				
				System.out.println(bowl);
			}
		}
	}
	
	public static void shorterCarPrompt(Scanner input) {
		String car = "";
		
		// while, for, and foreach loops do not end in a semi-colon
		// do-while loops do end in a semi-colon
		do {
			if (car.trim().equalsIgnoreCase("Volkswagen") ||
				car.trim().equalsIgnoreCase("VW")) {
				System.out.println("That brand sucks, pick a better one.");
			}
			
			System.out.print("Enter a car brand: ");
			car = input.nextLine();
		} while (car.trim().equalsIgnoreCase("Volkswagen") ||
				 car.trim().equalsIgnoreCase("VW") ||
				 car.trim().equals(""));
		
		System.out.println("Great Choice!");
	}
	
	public static void carPrompt(Scanner input) {
		System.out.print("Enter a car brand: ");
		String car = input.nextLine();
		
		// if the input is not valid, we repeat the prompt
		while (car.trim().equalsIgnoreCase("Volkswagen") || 
			   car.trim().equalsIgnoreCase("VW") ||
			   car.trim().equalsIgnoreCase("")) {
			System.out.println("That brand sucks, pick a better one");
			System.out.print("Enter a car brand: ");
			car = input.nextLine();
		}
		
		System.out.println("Great Choice!");
	}
}
