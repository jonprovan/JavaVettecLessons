package com.skillstorm.general;

public class Day4 {

	public static void main(String[] args) {
		int count = 0;
		
		while (count != 2) {
			System.out.println(count);
			count = count + 1;
		}
		
		System.out.println("Final count: " + count);
		System.out.println("outside the loop");
		
		//notInfiniteLoop();
		
		//integerOverflow();
		
		// increment/ decrement
		// shortcuts
		count = 0;
		count = count + 1; // same as line 27
		System.out.println(count); // 1
		
		count = 0;
		count += 1; // same as line 23
		System.out.println(count); // 1
		
		// same code
		count = 0;
		count = count + 34 - 36/2; // same as line 36
		System.out.println(count); // 16
		
		count = 0;
		count += 34 - 36/2; // same as line 32
		System.out.println(count); // 16
		
		// works for all the operations
		// +=
		// -=
		// /=
		// *=
		// %=
		// all equal:
		// variable = variable <operation> <equation>
		
		// pre-fix and postfix only change the value by 1
		// only addition and subtraction
		count = 0;
		count++; // post-fix increment
		System.out.println(count); // 1
		
		count = 0;
		count = count + 1; // the same as line 51 and 59
		System.out.println(count); // 1
		
		count = 0;
		++count; // pre-fix increment 
		System.out.println(count); // 1
		
		count = 0;
		count--;
		System.out.println(count); // -1
		
		count = 0;
		--count;
		System.out.println(count); // -1
		
		// can loop method calls
		// count is currently -1, i want this to run 3 times
		while (count < 2) {
			System.out.println("\n***** Array Loop " + (count + 2) +" ******");
			loopThroughArray();
			count += 1; // dont forget to update your conditions
		}
		System.out.println();
		
		String[] cookies = { "Chocolate Chip", 
							 "Oatmeal",
							 "Peanut Butter", 
							 "Sugar", 
							 "Snickerdoodle",
							 "M&M",
							 "Oatmeal No-bake" };
		loopStrings(cookies);
		
		System.out.println("\n****** Break Statement ******");
		loopCookiesWithBreak(cookies);
		
		System.out.println("\n****** Continue Statement ******");
		loopCookiesWithContinue(cookies);
		
		System.out.println("\n****** Without Continue Statement ******");
		loopCookiesWithoutContinue(cookies);
		
		System.out.println("\n******* Post-fix ********");
		postfixOperator();
		
		System.out.println("\n******* Pre-fix ********");
		prefixOperator();
	}
	
	public static void prefixOperator() {
		// pre-fix operator is ++variable or --variable;
		// pre-fix: the increment/ decrement happens before the variable is evaluated
		int myNumber = 0;
		
		System.out.println(++myNumber);
		// this operator always changes the value of the variable
		// no matter where it occurs
		//++myNumber;
		System.out.println(++myNumber);
		
		System.out.println(myNumber);
		
		int[] myArray = { 10, 11, 12, 13, 14, 15 };
		
		myNumber = -1;
		while (myNumber < myArray.length - 1) {
			// this does increment myNumber, so this is not an infinite loop
			// this throws an exception if im not careful
			System.out.println(myArray[++myNumber]);
		}
		
		myNumber = 0;
		while (myNumber < myArray.length) {
			// If the operation is outside of another method call, the 
			// order of evaluation does not matter
			System.out.println(myArray[myNumber]);
			
			++myNumber;
		}
	}
	
	public static void postfixOperator() {
		// post-fix operator is variable++ or variable--
		// post-fix: the increment/ decrement happens after the variable is evaluated
		int myNumber = 0;
		
		System.out.println(myNumber++);
		// this operator always changes the value of the variable
		// no matter where it occurs
		//myNumber++;
		System.out.println(myNumber++);
		
		System.out.println(myNumber);
		
		int[] myArray = { 10, 11, 12, 13, 14, 15 };
		
		myNumber = 0;
		while (myNumber < myArray.length) {
			// this increments myNumber every time it runs
			// increments it after it checks the value
			System.out.println(myArray[myNumber++]);
		}
		
		myNumber = 0;
		while (myNumber < myArray.length) {
			// If the operation is outside of another method call, the 
			// order of evaluation does not matter
			System.out.println(myArray[myNumber]);
			
			myNumber++;
		}
	}
	
	// same as the method loopCookiesWithContinue(String[])
	public static void loopCookiesWithoutContinue(String[] cArray) {
		int i = 0;
		
		System.out.println("Yesterday I ate: ");
		while (i < cArray.length) {
			if (cArray[i].length() < 8) {
				String temp = cArray[i] + " cookies";
				
				System.out.println(temp);
			}
			
			i++;
		}
	}
	
	public static void loopCookiesWithContinue(String[] cArray) {
		int i = 0;
		
		System.out.println("Yesterday I ate: ");
		while (i < cArray.length) {
			if (cArray[i].length() > 8) {
				i += 1;
				continue; // skips this iteration
			}
			
			String temp = cArray[i].concat(" cookie");
			
			System.out.println(temp);
			i += 1;
		}
	}
	
	public static void loopCookiesWithBreak(String[] cArray) {
		int i = 0; // local variable
		
		System.out.println("Yesterday I ate a: ");
		while (i < cArray.length) {
			if (cArray[i].equals("Peanut Butter")) {
				break; // exits the loop
			}
			// temporary variable
			// temp is scoped to my while loop
			String temp = cArray[i] + " cookie"; 
			
			System.out.println(temp);
			i += 1;
		}
		
		System.out.println("After my loop");
 	}
	
	public static void loopStrings(String[] cArray) {
		int i = 0; // local variable
		
		System.out.println("Yesterday I ate a: ");
		while (i < cArray.length) {
			// temporary variable
			// temp is scoped to my while loop
			String temp = cArray[i] + " cookie"; 
			
			System.out.println(temp);
			i += 1;
		}
		
		// temp does not exist outside the loop
		// System.out.println(temp);
 	}
	
	public static void loopThroughArray() {
		int[] nums = { 23, 7, 13, 4, 15, 67, 42, 72, 45, 81 };
		int i = 0;
		
		// generalizes redundant steps
		while (i < nums.length) {
			System.out.println(nums[i]);
			i += 2; // prints every other value
			// above is the same as: i = i + 2;
		}
	}
	
	public static void integerOverflow() {
		int count = 0;
		
		while (true) {
			System.out.println(count);
			count = count + 1000; // causes overflow
		}
	}
	
	public static void notInfiniteLoop() {
		int count = 1;
		
		// is actually not infinite
		while (count > 0) {
			System.out.println(count);
			count = count + 100; // would want to decrement this based on my condition
		}
		
		System.out.println("Final count: " + count);
		System.out.println("Outside the loop");
	}
}
