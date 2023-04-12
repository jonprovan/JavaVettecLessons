package com.skillstorm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		sorting();
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
