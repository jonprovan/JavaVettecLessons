package com.skillstorm.beans;

// today we're talking recursion
// recursion - anytime a method calls itself
// important consideration, if a method calls itself it never ends
public class Recursion {

	public Recursion() {
		// never do recursion in your constructors
		//Recursion temp = new Recursion();
	}
	
	// this is a StackOverflowError
	public void recurse() {
		System.out.println("In the method");
		recurse(); // Java doesnt say this is an error
		
		// this line is unreachable
		System.out.println("That was great");
	}
	
	// recursive methods need a return for them to work properly
	// this return/ condition is called a "base case"
	// recursion is for taking a large problem and breaking it up until it doesnt
	// make sense to break it any further, that point is your base case
	
	// why is recursion generally avoided?
	// very memory intensive
	// error prone
	
	// anything you can do with recursion, you can do in a loop
	public int sum(int x) {
		// we want to return the sum of every number from 0 -> x
		
		if (x == 0) { // this is our base case
			return 0;
		}
		// we need a return, but we also need a condition that tells us when the problem
		// is too small to break up further
		return x + sum(x-1);
	}
	
	public int iterativeSum(int x) {
		int sum = 0;
		
		for (int i = 0; i <= x; i++) { // have to make it inclusive
			sum += i;
		}
		
		return sum;
	}
	
	// big recursive algorithm is fibonacci sequence
	// fibonacci is the summation of the previous two numbers
	// 1 1 2 3 5 8 13 ...
	public long fibonacci(int n) {
		if (n <=1 ) { //base case
			return n; // will be either 0 or 1 at this point
		}
		// recursive call
		// return the sum of the two proceeding numbers
		return fibonacci(n - 1) + fibonacci(n - 2); 
	}
	
	public long iterativeFibonacci(int n) {
		long fib = 0; // the number we want to return
		long num1 = 1, num2 = 1; // the previous 2 values
		
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		
		for (int i = 2; i < n; i++) { // i tells us which number in the sequence we're on
			fib = num1 + num2; // fib = the previous two numbers added together
			
			// update the numbers
			num1 = num2;
			num2 = fib;
		}
		
		return fib;
	}
}
