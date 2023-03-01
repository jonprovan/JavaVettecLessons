package com.skillstorm.general;

public class Day3 {

	public static void main(String[] args) {
		int int1 = 7, int2 = 6;
		long long1 = 71;
		short short1 = 5;
		byte byte1 = 2;
		float float1 = 3.1416F;
		double double1 = 45.352;
		
		System.out.println(int1 + int2);
		
		System.out.println(long1 + int2);
		
		System.out.println(short1 + int1 + int2 + long1);
		
		System.out.println(int1 - int2);
		
		System.out.println(long1 - int2);
		
		System.out.println(short1 - int1 - int2 - long1);
		
		System.out.println(int1 * int2); // multiplication
		
		// integer division will always return an integer
		// 7 / 6 = ~1.167
		// integers do not round, they just ignore any decimals
		System.out.println(int1 / int2); // prints 1
		
		// 6 / 7 = ~0.857
		System.out.println(int2 / int1); // prints 0
		
		// 71 / 6 = ~11.83
		System.out.println(long1 / int2); // prints 11
		
		// 71 / 2 = 35.5
		System.out.println(long1 / byte1); // prints 35
		
		// floating point arithmetic returns a floating point value
		System.out.println(float1 + double1);
		
		System.out.println(float1 - double1);
		
		System.out.println(float1 * double1);
		
		System.out.println(float1 / double1);
		
		// i can add, mulitply, divide, subtract whole numbers and 
		// floating point numbers
		// implicitly java casts int2 to a double for this equation
		System.out.println(double1 * int2);
		System.out.println(double1 / int2);
		
		// casting does not change the original value
		System.out.println(int2);
		
		int intResult = 0;
		
		// 7 + 6 - 5 = 8
		intResult = int1 + int2 - short1;
		
		System.out.println(intResult);
		
		// 7 + 6 - 5 / 2  should be 10.5
		// 7 + 6 - 2
		// 13 - 2 = 11 because integers always return an integer
		intResult = int1 + int2 - short1 / byte1;
		
		System.out.println(intResult);
		
		// 7 + 6 - 5 * 7 + 5 / 2 should be -19.5
		// 7 + 6 - 35 + 5 / 2
		// 7 + 6 - 35 + 2
		// 13 - 35 + 2
		// -22 + 2 = -20
		intResult = int1 + int2 - short1 * int1 + short1 / byte1;
		
		System.out.println(intResult);
		
		double doubleResult = 0;
		
		doubleResult = int1 + int2 - short1 * int1 + short1 / byte1;
		
		System.out.println(doubleResult);
		
		// explicit casting is done with ()
		// 7.0 + 6 - 5 * 7 + 5 / 2 should be -19.5
		// 7.0 + 6 - 35 + 5 / 2
		// 7.0 + 6 - 35 + 2
		// 13.0 - 35 + 2
		// -22.0 + 2 = -20.0
		doubleResult = (double)int1 + int2 - short1 * int1 + short1 / byte1;
		
		System.out.println(doubleResult);
		
		// 7 + 6 - 5 * 7 + 5.0 / 2 should be -19.5
		// 7 + 6 - 35 + 5.0 / 2
		// 7 + 6 - 35 + 2.5
		// 13 - 35 + 2.5
		// -22 + 2.5 = -19.5
		doubleResult = int1 + int2 - short1 * int1 + (double)short1 / byte1;
		
		System.out.println(doubleResult);
		
		// 7.0 + 6 - 5 * 7 + 5 / 2 should be -19.5
		// 7.0 + 6 - 35 + 5 / 2
		// 7.0 + 6 - 35 + 2
		// 13.0 - 35 + 2
		// -22.0 + 2 = -20.0
		// will not implicitly convert from double to int
		intResult = (int)((double)int1 + int2 - short1 * int1 + short1 / byte1);
		
		System.out.println(intResult);
		
		short shortResult = 0;
		
		// narrow cast. going from a double (larger) to a short (smaller)
		shortResult = (short)((double)int1 + int2 - short1 * int1 + short1 / byte1);
		
		System.out.println(shortResult);
		
		// 7 - 6 * 5 + 3.1416 / 45.352 * 2 = ~-22.8614
		// 7 - 30 + 3.1416 / 45.352 * 2
		// 7 - 30 + 0.0692 * 2
		// 7 - 30 + 0.138
		// -23 + 0.138 = ~-22.861
		doubleResult = int1 - int2 * short1 + float1 / double1 * byte1;
		
		System.out.println(doubleResult);
		
		// 7 - 6 * (5 + 3.1416) / 45.352 * 2 should be ~4.846
		// 7 - 6 * 8.1416 / 45.352 * 2
		// 7 - 48.8484 / 45.352 * 2
		// 7 - 1.077 * 2
		// 7 - 2.1541 = ~4.8459
		doubleResult = int1 - int2 * (short1 + float1) / double1 * byte1;
		
		System.out.println(doubleResult);
		
		// 7 / 6 + 5 + 3.1416 - 45.352 / 2 should be ~-13.368
		// 1 + 5 + 3.1416 - 45.352 / 2
		// 1 + 5 + 3.1416 - 22.676
		// 6 + 3.1416 - 22.676
		// 9.1416 - 22.676 = ~-13.5344
		doubleResult = int1 / int2 + short1 + float1 - double1 / byte1;
		
		System.out.println(doubleResult);
		
		// 6 / 7 + 5 + 3.1416 - 45.352 / 71 should be ~8.3599
		// 0 + 5 + 3.1416 - 45.352 / 71
		// 0 + 5 + 3.1416 - 0.6388
		// 5 + 3.1316 - 0.6388
		// 8.1416 - 0.6388 = ~7.5028
		doubleResult = int2 / int1 + short1 + float1 - double1 / long1;
		
		System.out.println(doubleResult);
		
		//casting does not look at limits
		// overflow happens here
		int val = 50000;
		byte val2 = (byte)val;
		
		System.out.println(val2);
		
		// can use underscores to break up large numbers
		int val1 = 2_000_000_000;
		int val3 = 1_000_000_000;
		
		System.out.println(val1);
		System.out.println(val1 + val3);
		
		// modulus: returns the remainder of division
		// 8 / 3 = 2.67
		// does not return the decimal remainder
		// 3 goes into 8 twice, with 2 left over
		// 8 - (3 * 2)
		// 8 - 6 = 2
		System.out.println(8 % 3); // prints 2
		
		// 4 goes into 13, 3 times with 1 left over
		System.out.println(13 % 4); // print 1
		
		int someNumber = 16; //could be anything
		
		System.out.println(someNumber % 2); // even because this is 0
		
		System.out.println(someNumber % 3);
		
		// 16 / 4.5 = 3.555556
		// 16 - (4.5 * 3)
		// 16 - 13.5 = 2.5
		System.out.println(someNumber % 4.5);
		
		System.out.println(2.0 / 3.0); // 0.66666
		
		System.out.println(2.0 % 3.0); // 2.0
		
		//int zero = 0;
		
		// Java cannot divide by 0
		// check your numbers to make sure they arn't zero before dividing
		//System.out.println(8 / 0);
		
		//System.out.println(8 / zero);
	}
}
