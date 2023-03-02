package com.skillstorm.general;

public class Day4 {

	public static void main(String[] args) {
		// PEMDAS
		
		// power - exponents
		// first parameter is the base number,
		// second parameter is the power
		// 2 ^ 3
		System.out.println(Math.pow(2, 3));
		
		// 2.5 ^ 3.2
		System.out.println(Math.pow(2.5, 3.2));
		
		double result, double1 = 7.7, double2 = 10.9, double3 = 3.2;
		int int1 = 7, int2 = 3, int3 = 4;
		
		// (4 ^ 3) + 3 * ((10.9 / 3) ^ 2) - 7 * 10.9
		// (4 ^ 3) + 3 * (3.633 ^ 2) - 7 * 10.9
		// 64.0 + 3 * (3.633 ^ 2) - 7 * 10.9
		// 64.0 + 3 * 13.1987 - 7 * 10.9
		// 64.0 + 39.596 - 7 * 10.9
		// 64.0 + 39.596 - 76.3
		// 103.596 - 76.3 = ~27.293
		result = Math.pow(int3, 3) + int2 * Math.pow(double2 / int2, 2) - int1 * double2;
		System.out.println(result);
		
		// ((4 ^ 3) + 3 * ((10.9 / 3) ^ 2) - 7 * 10.9) ^ 2
		// ((4 ^ 3) + 3 * (3.633 ^ 2) - 7 * 10.9) ^ 2
		// (64.0 + 3 * (3.633 ^ 2) - 7 * 10.9) ^ 2
		// (64.0 + 3 * 13.1987 - 7 * 10.9) ^ 2
		// (64.0 + 39.596 - 7 * 10.9) ^ 2
		// (64.0 + 39.596 - 76.3) ^ 2
		// (103.596 - 76.3) ^ 2 
		// 27.293 ^ 2 = ~744.908
		// anything before the comma is the first parameter
		result = Math.pow(Math.pow(int3, 3) + int2 * Math.pow(double2 / int2, 2) - int1 * double2, 2);
		System.out.println(result);
		
		// 7.7 - 3.2 * ((7 ^ 4) / 3) + 3.2
		// 7.7 - 3.2 * (2401.0 / 3) + 3.2
		// 7.7 - 3.2 * (800.333) + 3.2
		// 7.7 - 2561.066 + 3.2
		// -2553.366 + 3.2 = ~-2550.166
		result = double1 - double3 * (Math.pow(int1, int3) / int2) + double3;
		System.out.println(result);
		
		// sqrt - square root function
		System.out.println(Math.sqrt(4));
		
		// (4 ^ 3) + 3 * sqrt(((10.9 / 3) ^ 2)) - 7 * 10.9
		// (4 ^ 3) + 3 * sqrt(3.633 ^ 2) - 7 * 10.9
		// 64.0 + 3 * 3.633 - 7 * 10.9
		// 64.0 + 10.899 - 7 * 10.9
		// 64.0 + 10.899 - 76.3
		// 74.899 - 76.3 = ~-1.401
		result = Math.pow(int3, 3) + int2 * Math.sqrt(Math.pow(double2 / int2, 2)) - int1 * double2;
		System.out.println(result);
		
		// functions take in parameters
		// functions and methods are the same thing
		// parameters and arguments are the same thing
		// .word()
		// anything in () is a parameter
		// parameters are separated by , 
		
		// sqrt(10.9 * 4 + 7.7) * (3 ^ (3.2 + 7)) - 7.7 / (10.9 * 7)
		// sqrt(10.9 * 4 + 7.7) * (3 ^ 10.2) - 7.7 / (10.9 * 7)
		// sqrt(43.6 + 7.7) * (3 ^ 10.2) - 7.7 / (10.9 * 7)
		// sqrt(51.3) * (3 ^ 10.2) - 7.7 / (10.9 * 7)
		// 7.162 * (3 ^ 10.2) - 7.7 / (10.9 * 7)
		// 7.162 * 73559.166 - 7.7 / (10.9 * 7)
		// 7.162 * 73559.166 - 7.7 / 76.3
		// 526830.747 - 7.7 / 76.3
		// 526830.747 - 0.101 = ~526830.646 -> rounding error on my part somewhere
		result = Math.sqrt(double2 * int3 + double1) * Math.pow(int2, double3 + int1) - double1 / (double2 * int1);
		System.out.println(result);
		
		// ceil and floor
		// ceil rounds up (your ceiling is above you)
		// floor round down (your floor is below you)
		// .....ideally....
		// both take in a double and return an whole number
		// they do not follow rounding rules, they find the next whole number
		// either above or below
		System.out.println(Math.ceil(2.4));
		System.out.println(Math.floor(2.4));
		
		// Strings
		// character sequences
		// a string is always represented by double quotes " "
		// not a primitive, strings are an object
		String firstName = "Miles";
		String lastName = "Mixon";
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		// this is string concatenation
		// it concatenates as is
		//concatenation 2 strings here
		System.out.println(firstName + lastName);
		System.out.println(firstName.concat(lastName));
		
		// concatenating 3 strings here
		System.out.println(firstName + " " + lastName);
		System.out.println(firstName.concat(" ").concat(lastName));
		
		// can concatenate numbers and strings
		System.out.println(firstName + result);
		System.out.println(firstName + ": " + result);
		
		System.out.println(firstName);
		
		// the string methods do not change the original string
		firstName.toLowerCase(); // does nothing
		String lowercaseName = firstName.toLowerCase(); // makes a new string
		
		System.out.println(firstName.toLowerCase()); // prints in lowercase
		System.out.println(firstName); // original is unchanged
		System.out.println(lowercaseName); // a different string, that is lowercase
		
		firstName.concat(lastName); // does nothing
		
		System.out.println(firstName); // unchanged
		
		System.out.println(lastName.toUpperCase()); // prints in all upper case
		
		// M i l e s   M i x o  n
		// 0 1 2 3 4 5 6 7 8 9  10 -> indexes
		// 1 2 3 4 5 6 7 8 9 10 11 -> length
		String fullName = firstName + " " + lastName;
		
		System.out.println(firstName.length()); // prints 5
		System.out.println(fullName.length()); // prints 11
		
		// length is a method, it does not take any parameters
		int len = firstName.length();
		
		System.out.println(len);
		
		// substring
		// can pick any index from 0 until the length of the string
		// gets a substring from the first index (inclusive) given to the last index (exclusive) given
		System.out.println(fullName.substring(1, 4)); // ile
		System.out.println(fullName.substring(4, 9)); // s Mix
		System.out.println(fullName.substring(8, 11)); // xon
		
		// goes from the given index to the end of the line
		System.out.println(fullName.substring(8)); // xon
		System.out.println(fullName.substring(1)); // iles Mixon
		
		fullName.substring(5, 8); // does nothing
		// does not change the original
		System.out.println(fullName);
		
		System.out.println(fullName.substring(6)); // Mixon
		System.out.println(fullName.substring(6, 11)); // Mixon
		
		System.out.println(fullName.substring(0, 5)); // Miles
		
		// == : equality comparison
		System.out.println(5 == 1 + 4);
		
		String name1 = "Dan Pickles";
		String name2 = "Dan Pickles";
		
		System.out.println(name1 == name2); // does not always work for string comparisons 
		System.out.println(name1.equals(name2)); // Should always use this for strings, this looks at the value
		System.out.println(name1 == "Dan Pickles");
		System.out.println("Dan Pickles" == "Dan Pickles");
		System.out.println("Dan Pickles" == "Dan " + "Pickles");
		System.out.println(name1 == "Dan " + "Pickles");
		
		System.out.println(new String("Dan Pickles") == "Dan Pickles"); // false
		System.out.println(new String("Dan Pickles").equals("Dan Pickles")); // true
		
		System.out.println(new String("Dan Pickles") == new String("Dan Pickles")); // false
		System.out.println(new String("Dan Pickles").equals(new String("Dan Pickles"))); // true
		
		// Take-away, ALWAYS use .equals for string comparisons
		
		String last = "MIxOn";
		String last2 = "mIXoN";
		
		System.out.println(last.equals(last2)); // false
		System.out.println(last.equalsIgnoreCase(last2)); // true
		
		String converted1 = last.toLowerCase();
		String converted2 = last2.toLowerCase();
	
		System.out.println(converted1.equals(converted2)); 
	}
}
