package com.skillstorm;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.skillstorm.beans.BetterInterface;
import com.skillstorm.beans.MyInterface;
import com.skillstorm.beans.PickupTruck;
import com.skillstorm.beans.Recursion;
import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Sorting;
import com.skillstorm.beans.Truck;
import com.skillstorm.beans.Vehicle.Color;

public class OCA {
	
	public static void main(String[] args) {
		//multiDimensionalLists();
		//enumTypes();
		//test1Review();
		
//		A o1 = new OCA().new C();
//		B o2 = (B) o1;
//		System.out.println(o1.m1()); // methods look at the physical object
//		System.out.println(o2.i); // fields look at the reference type
		
		//interfaces();
		//recursionExamples();
		//sorting();
		//dates();
		lambdas();
	}
	
	// OOP is a programming paradigm where we have Classes/ Objects that maintain state and
	// behavior as our data, this has what we call "side effects"
	
	// functional programming is a paradigm where you build your programs with expressions
	// and functions with no side effects
	
	// Predicates, Suppliers, Function, Consumer are all Functional Interfaces
	public static void lambdas() {
		// uses what is called a lambda,
		// lambda is an anonymous method denoted by -> 
		List<String> names = Arrays.asList("Tim", "Jim", "Joe", "Dan", "Sam", "Ron");
		
		// what type does it take in?
		// lambdas can take in 0 or more parameters, and then execute some code
		// predicates use lambda syntax, but they must return a boolean
		Predicate<List<String>> danPresent = strs -> strs.contains("Miles");
		
		// for lambdas I can include any amount of code, but if its a one liner I dont
		// need curly braces
		Predicate<List<String>> danPresent2 = strs -> { 
			System.out.println("Method 2!");
			return strs.contains("Dan"); 
		};
			
		// you use the test() method to kick off a predicate
		System.out.println(danPresent.test(names));
		System.out.println(danPresent2.test(names));
		
		// if i have no arguments I can just give it ()
		// I can use a Supplier to run some function and return some value
		// need to tell it that value
		// randomNumber returns a Double
		Supplier<Double> randomNumber = () -> Math.random();
		
		System.out.println(randomNumber.get()); // get returns a value
		System.out.println(randomNumber.get()); 
		System.out.println(randomNumber.get()); 
		
		// it takes in a value and does not return anything
		// does something with that value
		Consumer<String> printName = str -> System.out.println(str);
		
		for(String name : names) {
			printName.accept(name);
		}
		
		// takes in a value and returns a value
		// only takes in 2 values
		// first input is the parameter type
		// second input is the return
		Function<String, String> func = first -> first.concat(" Pickles");
		
		for (String name : names) {
			System.out.println(func.apply(name));
		}
		
		// if I have one abstract method that needs to be implemented, I can implement
		// it on the fly
		MyInterface myAction = () -> System.out.println("Doing the action!!!");
		myAction.action();
		
		MyInterface myAction2 = () -> System.out.println("Doing the action????");
		myAction2.action();
		
		// lambdas can take in multiple values
		// return types are also fine
		BetterInterface betterAction = (name, i, d) -> {
//			System.out.print(name + " ");
//			System.out.print(i + " ");
//			System.out.print(d);
			return name + " " + i + " " + d;
		};
		
		System.out.println(betterAction.action("Dan Pickles", 1, 34.6));
	}
	
	/* Line 62 is equivalent to
	 * public boolean _(List<String> strs) {
	 * 		return strs.contains("Dan");
	 * }
	 * 
	 * Line 79 is equivalent to
	 * public Double _() {
	 * 		return Math.random();
	 * }
	 */
	
	public static void dates() {
		// in Java, and most languages Dates and Time are their own data type
		// Java has a Date data type but most of it is deprecated in favor of LocalDate
		
		// Dates are immutable
		Date today = new Date(); // what this does is get the current time
		
		System.out.println(today);
		System.out.println(today.getTime()); // based off 1970, so not the most useful
		
		System.out.println();
		System.out.println("******** Local Date *******");
		// preferred is LocalDate
		// no constructor that we can access for LocalDate
		//LocalDate localToday = new LocalDate();
		LocalDate localToday = LocalDate.now(); // this makes a new local date
		System.out.println(localToday); 
		
		System.out.println(localToday.getDayOfMonth());
		System.out.println(localToday.isLeapYear());
		System.out.println(localToday.getDayOfWeek());
		
		// same as Strings
		LocalDate twoDays = localToday.plusDays(2); // need to save the value or i cant reference it
		
		System.out.println(localToday); // Dates are immutable
		System.out.println(twoDays);
		System.out.println(twoDays.minusMonths(4));
		System.out.println(twoDays);
		
		// Date and DateTime are slightly different
		// one includes the time and one doesnt
		// LocalDate has no time
		
		System.out.println();
		System.out.println("******** Local Date Time *******");
		// no public constructor for this too
		LocalDateTime todayTime = LocalDateTime.now();
		System.out.println(todayTime); // right of the T is the time, left is the date
		
		LocalDateTime twoWeeks = todayTime.plusWeeks(2);
		System.out.println(twoWeeks);
		
		// if you want to change how you date prints, you use a DateTimeFormatter
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
		System.out.println(todayTime.format(myFormat));
		System.out.println(twoWeeks.format(myFormat));
		
		DateTimeFormatter myFormat2 = DateTimeFormatter.ofPattern("hh:mm a MM/dd/yyyy");
		System.out.println(todayTime.format(myFormat2));
		System.out.println(twoWeeks.format(myFormat2));
		
		// cannot do this
		// no really way to add dates together
		//System.out.println(twoWeeks - todayTime);
		System.out.println(twoWeeks.isAfter(todayTime));
		
		// periods represent a length of time in days, months, years
		System.out.println(Period.between(localToday, twoDays));
		System.out.println(Period.between(localToday.minusYears(1), twoDays.plusMonths(2)));
		
		Duration duration1 = Duration.ZERO;
		duration1 = duration1.plusDays(40);
		
		Duration duration2 = Duration.ZERO;
		duration2 = duration1.plusDays(4);
		duration2 = duration2.plusHours(4);
		
		System.out.println(duration1);
		System.out.println(duration2);
		System.out.println(Duration.between(todayTime.minusYears(1), twoWeeks.plusMonths(2)));
	}
	
	public static void sorting() {
		int[] nums = { 12, 3, 7, 2, 20 };
		
		Sorting mySort = new Sorting();
		
		System.out.println("***** Bubble Sort *****");
		mySort.print(nums);
		mySort.bubbleSort(nums);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println();
		nums = new int[]{ 7, 12, 22, 43, 1, 16, 2, 45, 62, 3, 29, 77, 32 };
		mySort.print(nums);
		mySort.bubbleSort(nums);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println("\n\n***** Insertion Sort *****");
		nums = new int[]{ 12, 3, 7, 2, 20 };
		mySort.print(nums);
		mySort.insertionSort(nums);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println();
		nums = new int[]{ 7, 12, 22, 43, 1, 16, 2, 45, 62, 3, 29, 77, 32 };
		mySort.print(nums);
		mySort.insertionSort(nums);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println("\n\n***** Quick Sort *****");
		nums = new int[]{ 12, 3, 7, 2, 20 };
		mySort.print(nums);
		mySort.quicksort(nums, 0, nums.length - 1);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println();
		nums = new int[]{ 7, 12, 22, 43, 1, 16, 2, 45, 62, 3, 29, 77, 32 };
		mySort.print(nums);
		mySort.quicksort(nums, 0, nums.length - 1);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println("\n\n***** Merge Sort *****");
		nums = new int[]{ 12, 3, 7, 2, 20 };
		mySort.print(nums);
		mySort.mergeSort(nums, 0, nums.length - 1);
		System.out.print("Final: ");
		mySort.print(nums);
		
		System.out.println();
		nums = new int[]{ 7, 12, 22, 43, 1, 16, 2, 45, 62, 3, 29, 77, 32 };
		mySort.print(nums);
		mySort.mergeSort(nums, 0, nums.length - 1);
		System.out.print("Final: ");
		mySort.print(nums);
	}
	
	public static void recursionExamples() {
		Recursion recursive = new Recursion();
		
		//recursive.recurse(); // stack over flow
		
		System.out.println("***** Recursive *****");
		System.out.println(recursive.sum(20));
		System.out.println(recursive.sum(50));
		System.out.println(recursive.sum(77));
		
		// print first 10 numbers of sequence
		for (int i = 0; i < 50; i++) {
			System.out.print(recursive.fibonacci(i) + " ");
		}
		
		System.out.println();
		System.out.println("\n***** Iterative *****");
		
		System.out.println(recursive.iterativeSum(20));
		System.out.println(recursive.iterativeSum(50));
		System.out.println(recursive.iterativeSum(77));
		
		// print first 10 numbers of sequence
		for (int i = 0; i < 50; i++) {
			System.out.print(recursive.iterativeFibonacci(i) + " ");
		}
		
		System.out.println();
	}
	
	public static void interfaces() {
		PickupTruck truck1 = new PickupTruck();
		
		truck1.tow("boat");
		truck1.tow("sedan", 4.5);
		
		Truck.haul(5, "boat");
		
	}
	
	class A { int i = 10; int m1() { return i; } }
	class B extends A { int i = 20; int m1() { return i; } }
	class C extends B { int i = 30; int m1() { return i; } }
	
	public static void test1Review() {
		String str = "123".intern();
		long m = Long.valueOf(str);
		
		
	}
	
	public static void enumTypes() {
		// enums are their own type, similar to how boolean, int, etc are their own types
		// they also function very simialrly to classes though most do not use them as
		// a class
		Sedan car1 = new Sedan(Color.BLACK, "Toyota", "Camry");
		
		System.out.println(car1);
		
		// purple is not a value we defines, cannot change to it
		//car1.setColorV2(Color.PURPLE);
		//System.out.println(Color.valueOf("PURPLE"));
		//System.out.println(Color.valueOf("Blue")); // spelling does matter
		System.out.println(Color.valueOf("BLUE"));
	}
	
	public static void multiDimensionalLists() {
		// same way that we can have an array inside an array....
		// we can have a List inside a list....
		// same goes for other data structures
		
		// this task is better suited to multidimensional arrays, not Lists
		ArrayList<ArrayList<Integer>> myNums = new ArrayList<ArrayList<Integer>>();
		//System.out.println(myNums.get(9));
		myNums.add(new ArrayList<Integer>());
		myNums.get(0).add(4); // added for to index 0,0
		System.out.println(myNums);
		
		// this is what you want to use
		// I can see that this is a 10 x 10 array
		// i can see that, that wont change easily
		int[][] myNums2 = new int[10][10];
		System.out.println(myNums2[9]);
		myNums2[0][0] = 4;
		
		// where I would want to use an List over an array
		// nissanInvenotory essentially makes named buckets, in those buckets I throw 
		// cars that I have on me
		Map<String, ArrayList<Sedan>> nissanInventory = new HashMap<>();
		nissanInventory.put("Altima", new ArrayList<Sedan>()); // not I have a spot to put altimas
		nissanInventory.put("Maxima", new ArrayList<Sedan>());
		
		System.out.println(nissanInventory);
		
		Sedan altima1 = new Sedan();
		Sedan altima2 = new Sedan("Red", "Nissan", "Altima");
		Sedan maxima1 = new Sedan("White", "Nissan", "Maxima");
		
		// get my list of x Sedans and add in the new Sedan
//		nissanInventory.get("Altima").add(altima1);
//		nissanInventory.get("Altima").add(altima2);
//		nissanInventory.get("Maxima").add(maxima1);
		
		// what i did above
		ArrayList<Sedan> altimas = nissanInventory.get("Altima");
		altimas.add(altima1);
		altimas.add(altima2);
		
		ArrayList<Sedan> maximas = nissanInventory.get("Maxima");
		maximas.add(maxima1);
		
		// lists are better for things that change in size often, arrays are better for things
		// that do not change in size often
		System.out.println(nissanInventory);
		
		// can use the above to adjust the inventory as needed
		altimas.remove(altima2);
		
		System.out.println(nissanInventory);
		
		System.out.println("\n***** Add to Inventory *****");
		// to add in a new list of cars, for a new type of vehicle
		ArrayList<Sedan> sentras = new ArrayList<>();
		sentras.add(new Sedan("Orange", "Nissan", "Sentra"));
		sentras.add(new Sedan("Orange", "Nissan", "Sentra"));
		sentras.add(new Sedan("Green", "Nissan", "Sentra"));
		sentras.add(new Sedan("White", "Nissan", "Sentra"));
		
		// and again adjust the inventory
		nissanInventory.put("Sentra", sentras);
		nissanInventory.get("Altima").add(new Sedan("Red", "Nissan", "Altima"));
		nissanInventory.get("Altima").add(new Sedan("Red", "Nissan", "Altima"));
		
		System.out.println(nissanInventory);
		
		System.out.println("\n***** Update Model Name *****");
		// I want to update the model to be "Altima v2"
		System.out.println(nissanInventory.get("Altima"));
		
		for (Sedan nissan : nissanInventory.get("Altima")) {
			String name = nissan.getModel();
			name += " v2";
			
			nissan.setModel(name);
		}
		
		System.out.println(nissanInventory.get("Altima"));
		
		System.out.println("\n***** Update Colors *****");
		System.out.println(nissanInventory);
		// we want to update the colors in our inventory
		// Blue -> Sea Stone
		// Red -> Fiery Crimson
		// Orange -> Deep Autumn
		// White -> Pearl Egg Shell
		// Green -> Tropical Emerald
		// Maps are not iterable but Sets are, a foreach loop needs an iterable
		// Maps have an "entry set" which is a set of each key-value pair
		for (Map.Entry<String, ArrayList<Sedan>> entry : nissanInventory.entrySet()) {
			// the value for each entry is an arraylist that holds sedans
			for (Sedan car : entry.getValue()) {
				String color = car.getColor(); // so i only need to ask for this once
				
				// to lower case so that i dont need to worry about the case
				switch (color.toLowerCase()) { 
					case "blue":
						car.setColor("Sea Stone");
						break;
					case "red":
						car.setColor("Fiery Crimson");
						break;
					case "orange":
						car.setColor("Deep Autumn");
						break;
					case "white":
						car.setColor("Pearl Egg Shell");
						break;
					case "green":
						car.setColor("Tropical Emerald");
						break;
					case "black":
						car.setColor("Obsidian");
						break;
				}
			}
		}
		
		System.out.println(nissanInventory);
	}
}
