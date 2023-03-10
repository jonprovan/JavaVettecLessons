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
		
		shorterCarPrompt(in);
		
		in.close();
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
