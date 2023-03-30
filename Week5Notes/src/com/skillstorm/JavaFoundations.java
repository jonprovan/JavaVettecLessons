package com.skillstorm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Sedan.SedanColorComparator;
//if i import this, less hoops because it's static
import com.skillstorm.beans.Sedan.SedanColorComparator2; 

public class JavaFoundations {

	public static void main(String[] args) {
		//innerClasses();
		//switchStatements();
		//testMethod();
		
		//InitTest test = new InitTest();
		//arrayLists();
		//moreArrayLists();
		//shortCircuiting();
		ternaryOperator();
	}
	
	public static void ternaryOperator() {
		int val;
		int condition = 6;
		
		// if the condition is positive val = 2, else val = 3
		if (condition % 2 == 0) {
			val = 2;
		} else {
			val = 3;
		}
		
		System.out.println(val);
		
		//can do the above with a switch statement
		val = 0;
		
		switch (condition % 2) {
			case 0:
				val = 4;
				break;
			default: 
				val = 6;
				break;
		}
		
		System.out.println(val);

		// ternary operator
		// condition - is what you're checking (needs to be a boolean)
		// 		condition is ended by a ?
		// if true - return the part immediately after the ?. the true ends at the :
		// if false - return what's after the :
		val = 0;
		
		// is condition % 2 equal to 0?
		// if yes return 8
		// if no return 12
		val = condition % 2 == 0 ? 8 : 12;
		System.out.println(val);
		
		// best used for more straight forward 1-liners
		System.out.println(condition % 2 == 0 ? true : false);
		
		// can nest these. the innermost ? and : are together
		String result = condition % 2 == 0 
							? condition % 3 == 0 
								? condition % 4 == 0 
									? "Divisible by 4" 
									: condition % 6 == 0 
										? "Maybe it's 6" 
										: "not 6" 
								: "Not Divisible by 3" 
							: "Odd number";
		System.out.println(result);
		
		result = condition > 0 && condition < 6 
					? "Small Number" 
					: condition <= 0 
						? "negative" 
						: "larger number";
		System.out.println(result);
		
		result = condition > 0 && condition < 6 
					? "Weekday" 
					: condition <= 0 
						? "Not a valid day" 
						: condition > 5 && condition <= 7 
							? "Weekend" 
							: "Not a valid day";
		System.out.println(result);
	}
	
	public static void shortCircuiting() {
		// an optimization Java has made for processing boolean expressions
		// Java will only do the evaluations it needs to
		
		// A || B:
		// A == true the whole thing is true
		// at the point A is true the whole thing is true, so we ignore B
		
		// A && B:
		// A == false the whole thing is false
		// at the point A is false the whole thing is false, so we ignore B
		
		Sedan cyclone = null;
		int variable = 3;
		
		// if you call a method on null your code will crash
		// cyclone.getMake() will throw a NullPointerException
		System.out.println(variable == 3 || cyclone.getMake().equals("Cyclone"));
		
		// the above is a short-circuit. It sees that variable == 3 and doesnt even look
		// at the next part, which would throw a NullPointerException
		
		// evaluates left to right, the order does matter
		// always put your null checks first
		//System.out.println(cyclone.getMake().equals("Cyclone") || variable == 3);
		
		// cyclone is null. so it stops looking at the expression right there
		System.out.println(cyclone != null && cyclone.getMake().equals("Cyclone"));
		
		// both of the below throw exceptions, bitwise expressions do not short-circuit
		// this is still an or, both || and |
		// this is a bitwise or
		//System.out.println(variable == 3 | cyclone.getMake().equals("Cyclone"));
		
		// this is a bitwise and
		//System.out.println(cyclone != null & cyclone.getMake().equals("Cyclone"));
	}
	
	public static void moreArrayLists() {
		// would need to make a new array if i want to add more cars
		// that is a lot of code to type for arrays
		Sedan[] carArray = new Sedan[] { new Sedan(), new Sedan("Black", "Mitsubishi", "Evo"),
				new Sedan("Red", "Mazda", "RX8"), new Sedan("Silver", "Nissan", "Skyline") };
		
		// arrays do not implment Collections interface
		// but they can be turned into an arraylist
		// you go from an array to a list with Arrays.asList()
		ArrayList<Sedan> cars = new ArrayList<>(Arrays.asList(carArray));
		
		cars.add(new Sedan("Red", "Ford", "Fiesta"));
		cars.add(new Sedan("Black", "Ford", "Model T"));
		
		System.out.println(cars);
		
		// can turn my arraylist into an array
		//cars.toArray();
		
		// ArrayList.sort() uses a comparator and the comparator interface
		Sedan.SedanColorComparator2 comparator = new Sedan.SedanColorComparator2();
		cars.sort(comparator);
		System.out.println(cars);
		
		// Collections.sort() uses the Comparable and the compareTo() method
		Collections.sort(cars);
		System.out.println(cars);
		
		// can loop over arraylists just like arrays
		for(Sedan s : cars) {
			if (s.getColor().equals("Black")) {
				System.out.println(s);
			}
		}
		
		for (int i = 0; i < cars.size(); i++) {
			// must index into an arraylist with the get method, not []
			if (cars.get(i).getColor().equals("Red")) {
				System.out.println(cars.get(i));
			}
		}
	}
	
	public static void arrayLists() {
		// Arrays are a data structure
		// ArrayLists are also a data structure
		
		// an array implementation of the List interface
		// List, ArrayList, LinkedList are all a part of java.util
		// List is an interface, I cannot make an instance of a list
		//List<String> names = new List<Strings>();
		
		// ArrayList is a list, so this works 
		//List<String> names = new ArrayList<>();
		
		// ArrayLists have a starting capacity of 10
		// it is still a continuous block of memory, like an array
		// everytime it needs to resize it grows by 50%
		ArrayList<String> names = new ArrayList<>();
		
		// in the arrows I need to tell ArrayList the type of data im storing
		// Lists can only store objects
		// arrows are for type safety, and preferred
		// this works the same as above
		ArrayList<String> names3 = new ArrayList<String>();
		System.out.println(names3.isEmpty()); // nice method to tell if something is there
		
		// functions like a normal array with some differences
		
		String[] names2 = new String[3];
		//ArrayList<String> list2 = new ArrayList<>(3); // can tell it an initial capacity
		
		names2[0] = "Dan Pickles";
		names2[1] = "Miles Mixon";
		names2[2] = "Bruce Wayne";
		// want to get Clark in here so i need to resize
		//names2[3] = "Clark Kent"; // index out of bounds
		
		String[] temp = new String[4];
		for (int i = 0; i < names2.length; i++) {
			temp[i] = names2[i];
		}
		
		names2 = temp;
		names2[3] = "Clark Kent"; // now I have space
		
		// with arraylist on the other hand, you just add them
		// add method returns true or false, but just adds to the end of the arraylist
		names.add("Dan Pickles");
		names.add("Miles Mixon");
		names.add("Bruce Wayne");
		names.add("Clark Kent");
		
		System.out.println(names2); // prints the memory address
		System.out.println(names); // prints the data
		
		// Array.length is the max number of elements it can hold
		// ArrayList.size() returns how many items are actually in the List
		System.out.println(names2.length); // use the length property for arrays
		System.out.println(names.size()); // use the size() method for lists
		
		// arrays have me tell them how large i want them to be and they never change
		// arraylists can grow and shrink in size as needed
		
		// Lists also use indexes, and also start indexing at 0
		System.out.println(names2[1]);
		System.out.println(names.get(1)); // can still get index out of bounds exceptions
		
		names2[3] = "";
		names.remove("Clark Kent");
		
		System.out.println(names2.length);
		System.out.println(names.size()); // size() is the # of elements
		
		// Java has auto-boxing and auto-unboxing for primitives
		// auto-boxing: converting your primitive to object form
		// auto-unboxing: converting your object to primitive form 
		// the object and primitive forms are two different things
		
		// object forms of primitives
		// Integer = int
		// Short = short
		// Byte = byte
		// Long = long
		// Boolean = boolean
		// Character = char
		// Double = double
		// Float = float
		Integer val = 3; // auto-boxing
		int sameVal = 3;
		
		// auto-unboxing
		int result = val + sameVal;
		System.out.println(val);
		System.out.println(sameVal);
		System.out.println(result);
		
		// doesnt throw these on the heap like normal objects
		Integer val2 = val;
		val = 4;
		System.out.println(val);
		System.out.println(val2);
		
		// List works off of generics, and generics can only be objects
		//ArrayList<int> nums = new ArrayList<>(); // cant do this
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(3);
		nums.add(6);
		nums.add(62);
		nums.add(1);
		nums.add(16);
		nums.add(82);
		nums.add(23);
		nums.add(3); // it accepts duplicates just like arrays do
		nums.add(19);
		nums.add(52);
		nums.add(2);
		nums.add(73);
		
		// arraylist is an ordered collection
		// it maintains insertion order
		System.out.println(nums);
		System.out.println(nums.size());
		
		// remove just takes out the first occurrence of a value
		// returns true or false as to whether it removed something
		nums.remove(new Integer(3));
		System.out.println(nums);
		System.out.println(nums.size());
		
		nums.remove(Integer.valueOf(77));
		System.out.println(nums);
		System.out.println(nums.size());
		
		ArrayList<Double> doubles = new ArrayList<>();
		doubles.add(4.5);
		doubles.add(7.5);
		doubles.add(62.352);
		doubles.add(7.0);
		
		System.out.println(doubles);
		doubles.add(2, 84.3); // can specify where to add something
		System.out.println(doubles);
		
		System.out.println(nums.contains(3)); // useful method to check what is in your arraylist
		
		System.out.println(doubles.get(1));
		doubles.set(1, 73.813); // set returns the value it changed
		System.out.println(doubles);
	} 
	
	public static void testMethod() {
		try{ 
			System.out.println("m1 Starts");       
			throw new IndexOutOfBoundsException( "Big Bang " );     
		} catch(IndexOutOfBoundsException e) {          
			System.out.println("1"); 
			try {
				throw new NullPointerException();  
			} finally {
				System.out.println("5");
			}     
		} catch(NullPointerException e) {          
			System.out.println("2");          
			return;       
		} catch (Exception e) {          
			System.out.println("3");       
		} finally {          
			System.out.println("4");       
		}       
		System.out.println("END");
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
