package com.skillstorm.general;

public class ValidMethodsExercise {

	public static void main(String args[]) {
        System.out.println("Hello World");
        
        short x = 3;
        short y = 4;
        
        System.out.println(value(x, y));
	}
	
	public String myMethod() {
        return "Something";
	}
	
//	public static int addNumbers(int x, int y) {
//        System.out.println(x + y);
//	}
	
//	public double subtractNums (double x, double y, double z) {
//        return "The answer is : "  + (x + y + z);
//	}
	
//	public static printMessage(String message) {
//        System.out.println(message);
//	}
	
//	public static int () {
//        return 5 + 5;
//	}
	
	public static int value(short num1, short num2) {
        int answer = num1 * num2;

        return answer;
	}
}
