package com.skillstorm;

import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Sedan.SedanColorComparator;
//if i import this, less hoops because it's static
import com.skillstorm.beans.Sedan.SedanColorComparator2; 

public class JavaFoundations {

	public static void main(String[] args) {
		//innerClasses();
		switchStatements();
	}
	
	public static void switchStatements() {
		// another form of control flow
		// basically it is an alternate way to type an if-statement
		
		// has different rules from an if statements
		// switch statements only work with:
			// enum
			// String
			// int
			// char
			// byte
			// short
		String guardianClass = "";
		
		// you type switch (as if it's a method) and give it a value to switch on
		// you need a break, or switch statements just fall through
		switch(guardianClass.toLowerCase()) {
			case "hunter": // same as if guardianClass == Hunter
				System.out.println("Great Choice!");
				//innerClasses();
				break; // need this to stop execution of the switch
			case "warlock": // same as if guardianClass == Warlock
				System.out.println("Eww");
				break;
			case "titan": // same as if guardianClass == Titan
				System.out.println("Double Eww");
				break;
			default: // same as else, except it does not have to be the last thing
				System.out.println("You're no guardian I know");
				break;
		}
		
		// can use numbers, actually does check if the type i hand the switch matches the type
		// of the cases
		int rank = 1;
		switch(rank) {
			case 1: // same as if rank == 1
				System.out.println("Hunter");
				break; // need this to stop execution of the switch
			case 2: // same as if rank == 2
				System.out.println("Warlock");
				break;
			case 3: // same as if rank == 3
				System.out.println("Titan");
				break;
			default: // same as else, except it does not have to be the last thing
				System.out.println("You're no guardian I know");
				break;
		}
		
		System.out.println("The method is over");
	}
	
	public static void innerClasses() {
		Sedan car = new Sedan();
		
		// cannot make an instance of an inner class by its self
		//SedanColorComparator comparator = new SedanColorComparator();
		// must go through an instance of the outer class to make an inner one
		SedanColorComparator comparator = new Sedan().new SedanColorComparator();
		comparator.method();
		
		// difficult to go through an already existing instance
		SedanColorComparator comparator2 = car.new SedanColorComparator();
		comparator2.method();
		
		// still need the outer class, but do not need an instance of it
		// if i import the inner class then i dont need to mention the outer one
		SedanColorComparator2 comparator3 = new SedanColorComparator2();
	}
}
