package com.skillstorm;

public class Program {

	public static void main(String[] args) {
		System.out.println(factorial(3)); // should be 6
		System.out.println(factorial(6)); // should be 720
		System.out.println(factorial(10)); // should be 3,628,800
		System.out.println(factorial(0)); // should return 1
		System.out.println(factorial(1)); // should return 1
		try {
			System.out.println(factorial(-20)); // should return 1
		} catch (IllegalArgumentException ex) {
			System.out.println("Failed successfully");
		}
	}
	
	// Calculating Factorials
	public static long factorial(int n) {
		// if n is negative
		// if n is 0 (our base case)
		// else multiply
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return 1;
		} else {
			return (long)n * factorial(n-1); 
		}
	}
}
