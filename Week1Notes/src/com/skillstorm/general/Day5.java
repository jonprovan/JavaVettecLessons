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
		
		//There is still a newline character in the buffer
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
		
		if (topping.equalsIgnoreCase("Anchovies")) {
			System.out.println("Eww");
		}
		
		int weight;
		
		if (topping.equalsIgnoreCase("Pepperoni")) {
			weight = 1;
			System.out.println(weight);
		}
		
		if (topping.equalsIgnoreCase("Pineapple")) {
			weight = 2;
			System.out.println(weight);
		}
		
		if (topping.equalsIgnoreCase("Chicken")) {
			weight = 3;
			System.out.println(weight);
		}
		
		int val = 10;
		// if statements use {} to show which lines of code go with the if
		// if statements do not need the {} if there is only one line of code inside the statement
		if (val > 20)
			System.out.println("Thats a big number!");
		
		System.out.println("Am I in the if?"); // this is outside the if
		
		// if-else
		// a normal if statement, but has an extra piece that happens if the statement is false
		// the else piece is optional
		if (val > 20) {
			System.out.println("Lucky number!");
		} else {
			System.out.println("Not your lucky number");
		}
		
		// can write these without {} if there is only one line
		if (val > 20)
			System.out.println("1-line: lucky number");
		else
			System.out.println("1-line: you're still unlucky");
		
		if (!topping.equalsIgnoreCase("Anchovies")) {
			System.out.println("You talked me into pizza");
		} else {
			System.out.println("All of a sudden I dont want pizza");
		}
		
		System.out.println("What's your favorite color?: ");
		
		String color = in.nextLine();
		
		if (color.equalsIgnoreCase("Blue")) {
			System.out.println("You're right");
		} else {
			System.out.println("You're wrong");
		}
		
		int weight2;
		
		// if-else if
		// can have only one if
		// can have only one else
		// can have as many else ifs as you want
		// else must be last and if must be first
		// checks the conditions in order
		if (topping.equalsIgnoreCase("Pepperoni")) {
			weight2 = 1;
		} else if (topping.equalsIgnoreCase("Pineapple")) {
			weight2 = 2;
		} else if (topping.equalsIgnoreCase("Chicken")) {
			weight2 = 3;
		} else {
			weight2 = 4;
		}
		
		System.out.println(weight2);
		
		int variable = 27;
		
		// order of these statements does matter
		if (variable > 23) {
			System.out.println("Value is greater than 23");
		} else if(variable == 27) {
			System.out.println("Value is 27!"); // this wont execute
		} else {
			System.out.println("not sure what to tell you");
		} 
		
		// the else is optional here too
		// you do not need the {} for 1 line statements
		if (variable < 3)
			System.out.println("Value is less than 3");
		else if(variable == 27)
			System.out.println("Value is 27!");
		 
		System.out.println("outside the if else");
		
		// can nest these
		// nesting = putting the statement inside another statement
		if (variable >= 20) {
			if (variable <= 30) {
				System.out.println("the number is between 20 and 30");
			} else {
				System.out.println("way more than 20");
			}
		} else {
			if (variable >= 0) {
				System.out.println("Atleast it's positive"); 
			} else {
				System.out.println("Negative number");
			}
		}
		
		// still works the same way as above, but far less readable
		if (variable >= 20)
			if (variable <= 30)
				System.out.println("the number is between 20 and 30");
			else
				System.out.println("way more than 20");
		else
			if (variable >= 0)
				System.out.println("Atleast it's positive"); 
			else
				System.out.println("Negative number");
		
		in.close();
	}
}
