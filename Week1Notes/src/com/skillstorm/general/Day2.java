package com.skillstorm.general;

import java.util.Scanner;

public class Day2 {

	/*
	 * Java is what is a called a "strongly typed" language
	 * Has many meanings, it is very strict about it's types
	 * 
	 * In Java everything is typed
	 * The rules around that type never change
	 */
	public static void main(String[] args) {
		// variables - a way for you to reserve a spot in memory for a value
		// variables just hold values
		// a variable can be anything
		
		// cannot use a keyword as a variable name
		// cannot start with a number, you can use _ and $ 
		// but should not start with them
		
		// to define a variable you give it a type and a name
		// cannot change between non-compatible types
		
		//*** primitive types ***
		
		// int represents an integer
		// it is a 32 bit whole number
		// whole number from -2^31 - (2^31)-1 -> a little over 2 billion
		// default whole number type
		int favoriteNumber; // un-initialized
		
		// initialized = when I give a variable a value
		favoriteNumber = 7; // initialized
		System.out.println(favoriteNumber);
		
		int twentyOne = 21;
		
		twentyOne = 31; // reassignment
		
		//twentyOne = "Miles"; // can only store compatible types
		
		System.out.println(twentyOne);
		
		int favoriteNumber2 = 36;
		
		// ctrl+space pulls up intellisense (auto-fill)
		System.out.println(favoriteNumber2);
		
		// bit - the smallest unit of measurement in a computer
		// represents either a 1 or a 0
		
		// byte - 8 bit whole number from -128 to 127
		byte smallNumber = 120;
		// byte smallNumber = 130; // too large
		
		System.out.println(smallNumber);

		// can store a smaller value in a larger one
		favoriteNumber2 = smallNumber; // compatible types

		// cannot store a larger value in a smaller one
		// smallNumber = favoriteNumber2;
		
		// short - 16 bit whole number
		// range from -2^15 to (2^15)-1
		short smallishNumber = 345;
		
		System.out.println(smallishNumber);
		
		favoriteNumber2 = smallishNumber;
		
		// long - 64 bit a whole number 
		// -2^63 to (2^63)-1. ~9 quintrillion and some change
		
		// if its in int range, i dont need anything special
		long bigNumber = 10000; 
		// need to use an L after im past the integer range
		long bigBigNumber = 20000000000L; 
		long bigBigNumber2 = 30000000000l;

		System.out.println(bigNumber);
		System.out.println(bigBigNumber);
		System.out.println(bigBigNumber2);
		
		bigNumber = favoriteNumber2; // 64 bits can fit potentially 32 bits
		bigNumber = smallishNumber; // 64 bits can fit potentially 16 bits
		bigNumber = smallNumber; // 64 bits can fit potentially 8 bits
		
		System.out.println(smallNumber);
		System.out.println(bigNumber);
		
		//smallNumber = bigNumber; // 8 bits cannot fit potentially 64 bits
		
		// character - 16 bit whole number
		// characters follow the ASCII table
		// single quote for character literals
		char letter = 'A';
		char letter2 = 56; // 8 in ASCII
		
		System.out.println(letter);
		System.out.println(letter2);
		
		char exclamation = 33;
		System.out.println(exclamation);
		
		char letter3 = 65;
		System.out.println(letter3);
		
		favoriteNumber = letter3;
		
		System.out.println(favoriteNumber);
		
		// boolean - either true or false
		boolean myBoolean = true;
		
		System.out.println(myBoolean);
		
		// double - 64 bit number that can have a decimal portion
		// default decimal type
		double decimal = 45670.56720274820184792021848;
		
		System.out.println(decimal);
		
		// tacks on the decimal piece whether i define it or not
		// an int will fit into a double
		double decimal2 = 3000;
		System.out.println(decimal2);
		
		// float - 32 bit number that can have a decimal portion
		// can define multiple variable of the same type in one line
		float smallDecimal = 3.5F, smallDecimal2 = 4.5f;
		
		// can edit how i display text, but it will do math if i dont have
		// text
		System.out.println(smallDecimal + " " + smallDecimal2);
		System.out.println(smallDecimal + smallDecimal2);
		System.out.println(smallDecimal2);
		
		long phoneNumber = 6453422345L;
		float weight = 134.54F;
		short lightLevel = 1600;
		int ssn = 345312846;
		double length, width, height;
		int age = 200000000;
		double speed = 88.0;
		float flux = 1.21f;
		boolean pet = true;
		byte classroomNumber = 123;
		
		// NOT a primitive type
		String name = "Miles Mixon"; // strings use double quotes
		char initial = 'M'; // characters use single quotes
		
		// maybe we want user input
		System.out.print("What is your name?: ");
		
		// to print something we use System.out
		// to read something we use System.in
		// we hand System.in to a Scanner
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		
		System.out.println("Hello, " + input);
		
		System.out.print("Enter a number: ");
		
		// what you tell it to read is what it will look for
		int inputNumber = in.nextInt();
		
		System.out.println(inputNumber);
		
		// scanner does not close by default
		in.close(); //cannot use it again after this
	}
}
