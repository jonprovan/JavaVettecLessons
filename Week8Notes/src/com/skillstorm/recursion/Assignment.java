package com.skillstorm.recursion;

import java.util.Arrays;

public class Assignment {

	public static void main(String[] args) {
		
	}
	
	// check if a given array has a value larger than 100
	// for recursion we need to break the problem smaller and smaller each time
	// 1. check if the length of the array is 0 (return false/ base case)
	// 2. check the first index against 100 ( > 100 return true)
	// 3. make a new array that doesnt have index 0
	// 4. call the method again with the new array
	public static boolean containsLargerThan100(int[] nums) {
		if (nums == null || nums.length == 0) { // good to do a null check
			return false;
		} else if (nums[0] > 100) {
			return true;
		}
		
		int[] newNums = Arrays.copyOfRange(nums, 1, nums.length);
		return containsLargerThan100(newNums);
	}
	
	// we take in a start value and an end value
	// and want to add just the even numbers
	// the way we make this smaller is is move start along the number line
	// 1. is start > end? throw an exception
	// 2. it's exclusive so when start == end you stop
	// 3. check if the current value is even 
	// 4. if even, then add it to your next call
	// 5. if odd, make your next call
	public static int evenSum(int start, int end) {
		if (start > end) {
			throw new IllegalArgumentException();
		} else if (start == end) {
			return 0;
		}
		
		if (start % 2 == 0) {
			// it's even
			return start + evenSum(start + 1, end);
		} else {
			// it's odd
			return evenSum(start + 1, end);
		}
	}
	
	public static boolean containsLargerThanN(int[] nums, int n) {
		if (nums == null || nums.length == 0) { // good to do a null check
			return false;
		} else if (nums[0] > n) {
			return true;
		}
		
		int[] newNums = Arrays.copyOfRange(nums, 1, nums.length);
		return containsLargerThanN(newNums, n);
	}
}
