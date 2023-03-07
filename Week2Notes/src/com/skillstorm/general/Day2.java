package com.skillstorm.general;

public class Day2 {

	public static void main(String[] args) {
		System.out.println("Day2, all about overloading");

		// calls to different methods with the same name
		System.out.println(getCookie(40));
		System.out.println(getCookie());
		System.out.println(getCookie(40.0));
		System.out.println(getCookie(6, "Snickerdoodle"));
		System.out.println("You get " + getCookie("Oatmeal") + " cookies");
		System.out.println("You get " + getCookie("M&M") + " cookies");
		System.out.println("You get " + getCookie("Macadamia Nut") + " cookies");
		System.out.println("You get " + getCookie("Sugar") + " cookies");
		System.out.println(getCookie(getCookie("Chocolate Chip"), getCookie("Salted Caramel")));
		System.out.println(getCookie(getCookie("Sugar"), 2.75));
		
		// we've eaten 96 cookies so far....that they know of...
		// we round down. because less to run
		System.out.println("You ran " + Math.floor(getCookie(0.5, 96)) + " miles to work off those cookies");
	}
	
	// method overloading
	// two methods with the same name and a different number or type or parameters
	public static String getCookie() {
		return "Chocolate Chip";
	}
	
	public static String getCookie(int num) {
		return "Chocolate Chip x" + num;
	}
	
	public static String getCookie(int num, String type) {
		return type + " cookies x" + num;
	}
	
	public static String getCookie(int num, int num2) {
		return "You ate " + (num + num2) + " cookies!";
	}
	
	public static String getCookie(int num1, double num2) {
		double tax = 0.06; // 6% tax
		double price = (num1 * num2) * (1 + tax);
		
		return String.format("You ate %d cookies at $%.2f each for a total of $%.2f", 
				num1, num2, price);
	}
	
	public static double getCookie(double distance, int cookies) {
		// distance = distance per cookie
		// cookie = cookies eaten...that you know of
		return distance * cookies + distance / (cookies / 4);
	}
	
	public static String getCookie(double num) {
		return "Sharing " + num + " Sugar cookies";
		//return "Chocolate Chip x" + num;
	}
	
	// can change the return type with an overload
	public static int getCookie(String type) {
		if (type.equalsIgnoreCase("Chocolate Chip") ||
			type.equalsIgnoreCase("Sugar")) {
			return 42;
		} else if (type.equalsIgnoreCase("Oatmeal")) {
			return 23;
		} else if (type.equalsIgnoreCase("Peanut Butter Chocolate Chip") ||
				   type.equalsIgnoreCase("Raisin")) {
			return 7;
		} else {
			return 12;
		}
	}
}
