package com.skillstorm.general;

import java.util.Scanner;

public class Day5 {

	public static void main(String[] args) {
		int num = 5; // same way that numbers can come from math expressions
		boolean bool = num == 5; // booleans can be boolean expressions
		
		System.out.println(bool);
		System.out.println(!bool); // just prints the opposite
		
		System.out.println(num == 5); // equal
		System.out.println(num > 5); // greater than
		System.out.println(num < 5); // less than
		System.out.println(num >= 5); // greater than or equal to
		System.out.println(num <= 5); // less than or equal to
		System.out.println(num != 5); // not equal
		
		// ! : not
		// && : and
		// || : or
		System.out.println(num > 5 || num == 5); // true
		System.out.println(num > 4 && num == 5); // true
		System.out.println(num > 4 && num != 5); // false
		//               num not greater than 4
		System.out.println(!(num > 4) && num == 5);
		System.out.println(!(num > 4 && num == 5)); // false, because it flips the return
		System.out.println(!(num > 4 && num != 5)); // true 
		
		// can chain as many as I want
		System.out.println(num > 4 || num < 1 || num == 7);
		System.out.println(num > 4 && num < 1 && num == 7);
		System.out.println(num > 4 || num < 1 && num == 7);
		// The above is doing this -> System.out.println(num > 4 || (num < 1 && num == 7));
		System.out.println((num > 4 || num < 1) && num == 7);
		System.out.println(num > 4 || (num < 1 && num == 7) || num % 2 == 0);
		
		int value = 7;
		boolean expression = value == 5;
		
		// Java can use these expressions in if statements
		// if the expression in the () is true execute the code in the {}
		if (expression) {
			System.out.println("It's true!!");
		}
		
		// if the above is false it skips over it
		System.out.println("Past the if");
		
		if (value + 3 == 7 || value % 2 == 0) {
			System.out.println("It was 4, or even");
		}
		
		if (value % 2 != 0) {
			System.out.println("Value is odd");
		}
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What's the best Destiny class?: ");
		
		String guess = in.nextLine();
		
		if (guess.equalsIgnoreCase("Hunter")) {
			expression = true; // just updates the value of expression
			System.out.println("You're right!");
			System.out.println("We have capes, so instantly the best");
		}
		
		System.out.println("Done");
		
		if (expression) {
			System.out.println("You guessed right earlier");
		}
		
		if (!expression) {
			System.out.println("Better luck next time");
		}
		
		System.out.println("Guess what number im thinking of: ");
		
		int guess2 = in.nextInt();
		
		if (guess2 == 23) {
			System.out.println("You guessed right!");
		}
		
		if (guess2 != 23) {
			System.out.println("You guessed wrong!");
		}
		
		in.nextLine();
		
		System.out.println("What pizza topping do you want?: ");
		
		String topping = in.nextLine();
		String acceptable = "Pineapple Pepperoni Chicken";
		
		// any of these 3 toppings trigger this
		if (topping.equalsIgnoreCase("Pineapple") || 
			topping.equalsIgnoreCase("Pepperoni") ||
			topping.equalsIgnoreCase("Chicken")) {
			System.out.println("Great choice");
		}
		
		// hacky way of doing it
		if (acceptable.contains(topping)) {
			System.out.println("Hacky great choice");
		}
		
		// can negate anything with !, so in this case is the topping isnt anchovies
		if (!topping.equalsIgnoreCase("Anchovies")) {
			System.out.println("Good choice");
		}
		
		// TODO: assign values to a variable based on user input 
		// TODO: run with pepperoni
		
		in.close();
	}
}
