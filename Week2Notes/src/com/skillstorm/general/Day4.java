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
