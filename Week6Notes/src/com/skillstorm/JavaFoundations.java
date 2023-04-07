package com.skillstorm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.skillstorm.beans.MyGeneric;
import com.skillstorm.beans.MyGeneric2;
import com.skillstorm.beans.MyLinkedList;
import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Vehicle;

public class JavaFoundations {

	public static void main(String[] args) {
		//staticStuff();
		//linkedLists();
		//customLinkedList();
		//genericClass();
		//moreDataStructures();
		//maps();
		//sets();
		multiDimensionalArrays();
	}
	
	public static void multiDimensionalArrays() {
		int[] lap1 = new int[5]; // normal array
		int[] lap2 = new int[5];
		
		// can do the above for storing lap times in 1 array
		
		// this is a 2D array. it is 2 x 5
		int[][] laps = new int[2][5];
		/*
		 * [ 7, 0, 6, 0, 0 ]
		 * [ 0, 8, 0, 0, 4 ]
		 */
		
		lap1[2] = 6; // with a normal array
		laps[0][2] = 6; // with a 2D array, change the 2nd index of array 0
		
		lap2[1] = 8;
		laps[1][1] = 8;
		
		lap1[0] = 7;
		laps[0][0] = 7;
		
		lap2[4] = 4;
		laps[1][4] = 4;
		
		// for 1 dimensional arrays
		System.out.print("[ ");
		for (int i = 0; i < lap1.length; i++) {
			System.out.print(lap1[i] + ", ");
		}
		System.out.println("]");
		
		System.out.print("[ ");
		for (int j = 0; j < lap2.length; j++) {
			System.out.print(lap2[j] + ", ");
		}
		System.out.println("]\n");
		
		// for a 2D array, it's a little harder
		// laps.length = 2
		// laps[0].length = 5
		// laps[1].length = 5
		for (int x = 0; x < laps.length; x++) {
			// each of my two lengths are the same here
			System.out.print("[ ");
			for (int y = 0; y < laps[0].length; y++) {
				System.out.print(laps[x][y] + ", ");
			}
			System.out.println("]");
		}
		
		// 3 x 4 array
		int[][] nums = new int[3][4];
		/*
		 * [ 1, 2, 3, 4 ]
		 * [ 5, 6, 7, 8 ]
		 * [ 9, 10, 11, 12 ]
		 */
		System.out.println();
		int count = 1; // the number im on
		// need to loop through all my rows
		for (int row = 0; row < nums.length; row++) {
			// need to loop through every column
			for (int column = 0; column < nums[0].length; column++) {
				nums[row][column] = count; 
				count++;
			}
		}
		
		// to print them out is the same as above
		for (int row = 0; row < nums.length; row++) {
			System.out.print("[ ");
			for (int column = 0; column < nums[0].length; column++) {
				System.out.print(nums[row][column] + " ");
			}
			System.out.println("]");
		}
		
		// jagged arrays
		// only the first dimension is required for multidimensional arrays
		int[][] jaggedNums = new int[4][];
		/*
		 * []
		 * []
		 * []
		 * []
		 */
		
		// I can manually define different sizes at a later point
		// jaggedNums is an array of arrays that hold ints
		jaggedNums[0] = new int[3];
		jaggedNums[1] = new int[5];
		jaggedNums[2] = new int[1];
		jaggedNums[3] = new int[3];
		/*
		 * [ 1, 2, 3 ]
		 * [ 4, 5, 6, 7, 8 ]
		 * [ 9 ]
		 * [ 10, 11, 12 ]
		 */
		
		System.out.println();
		//if i want to assign these have to be a bit more creative
		count = 1;
		// still need to iterate through every row
		for (int row = 0; row < jaggedNums.length; row++) {
			// but now the number of columns changes every time, potentially
			// now i need to ask each row for it's length
			for (int column = 0; column < jaggedNums[row].length; column++) {
				jaggedNums[row][column] = count;
				count++;
			}
		}
		
		// if i want to print them, its the same as above
		// still need to iterate through every row
		for (int row = 0; row < jaggedNums.length; row++) {
			System.out.print("[ ");
			// but now the number of columns changes every time, potentially
			// now i need to ask each row for it's length
			for (int column = 0; column < jaggedNums[row].length; column++) {
				System.out.print(jaggedNums[row][column] + " ");
			}
			System.out.println("]");
		}
		
		// a 3D array, can keep adding dimensions, but it stops being particularly useful
		// after 3 dimensions (there are only 3 dimensions we know of)
		// cannot have a blank [] and then a [] with a number in it
		// this is a 3 x 3 x 2 array
		int[][][] thirdDimension = new int[3][3][2];
		
		// if i want to print a 3D array, I need 3 loops
		
		// can use a foreach loop same as with other arrays
		// loop through each elemnt in our 3 x 4 array nums
		System.out.println("\n***** Foreach Nums *****");
		for (int[] row : nums) {
			// each element in nums is an array of ints
			System.out.print("[ ");
			for (int value : row) {
				// row is itself an array, that holds an int
				System.out.print(value + " ");
			}
			System.out.println("]");
		}
		
		// loop through each element in our jagged array
		System.out.println("\n***** Foreach Jagged Array *****");
		for (int[] row : jaggedNums) {
			System.out.print("[ ");
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println("]");
		}
		
		// I can define the starting values for an array like this
		int[] arrayLiteral = { 3, 45, 6, 3 };
		int[] arrayLiteral2 = new int[] { 3, 45, 6, 3 };
		
		// Can do the same with multi-dimensional arrays
		// this is a 3 x 3 array
		int[][] arrayLiteral2D = { { 1, 3, 4 }, { 2, 6, 7 }, { 5, 6, 82 } };
		int[][] arrayLiteral2D2 = new int[][] { { 1, 3, 4 }, { 2, 6, 7 }, { 5, 6, 82 } };
		
		// all of these are valid ways to declare an array
		int array[] = new int[3];
		int array2[][] = new int[3][];
		int[] array3[] = new int[3][];
		
		System.out.println("\n***** 3D array *****");
		// 2 x 3 x 2 array
		int[][][] array3D = { 
								{ 
									{1, 2}, 
									{1, 2}, 
									{1, 2} 
								}, 
								{ 
									{1, 2}, 
									{1, 2}, 
									{1, 2} 
								} 
							};
		
		// if i were to print it
		for (int row = 0; row < array3D.length; row++) {
			System.out.println("[");
			for (int column = 0; column < array3D[row].length; column++) {
				System.out.print("    [ ");
				for (int depth = 0; depth < array3D[row][column].length; depth++) {
					System.out.print(array3D[row][column][depth] + " ");
				}
				System.out.println("]");
			}
			System.out.println("]");
		}
	}
	
	public static void sets() {
		// Sets are a sort of compliment to Maps
		// Maps allow duplicates
		// Sets do not allow duplicates
		// Sets do not allow indexed access
		
		Set<String> names = new HashSet<>();
		names.add("Dan Pickles");
		names.add("Miles");
		names.add("Jon");
		names.add("Erica");
		names.add("Patrick");
		names.add("Austin");
		names.add("Dan Pickles"); // ignores this because it's a duplicate
		
		System.out.println(names);
		System.out.println(names.contains("Dan Pickles"));
		
		System.out.println("***** For each *****");
		// can loop over a hashSet, but cannot access a specific element
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("***** Iterator *****");
		// Iterator, a special class that represents an unchanging set of the values
		// that I can then loop over
		Iterator<String> hashSetIterator = names.iterator();
		// iterators will return null, similar to a LinkedList, so we have to check for that
		while (hashSetIterator.hasNext()) {
			// if i can grab the next value without throwing an exception
			// next() will throw an exception is there is no value to grab
			String name = hashSetIterator.next(); 
			System.out.println(name);
		}
		
		// both of the above loops are exactly the same
		
		System.out.println("***** Tree Set *****");
		// a set, but sorted
		// can use comparable or comparator
		Set<String> sNames = new TreeSet<>();
		sNames.add("Dan Pickles");
		sNames.add("Miles");
		sNames.add("Jon");
		sNames.add("Erica");
		sNames.add("Patrick");
		sNames.add("Austin");
		sNames.add("Dan Pickles");
		
		System.out.println(sNames);
		
		Sedan car1 = new Sedan();
		Sedan car2 = new Sedan();
		Sedan car3 = new Sedan("Black", "Toyota", "Corolla");
		Sedan car4 = new Sedan("Red", "Honda", "Civic");
		
		System.out.println("\n***** Inventory with Comparable *****");
		Set<Sedan> sInventory = new TreeSet<>();
		sInventory.add(car1); // Blue Nissan Altima
		sInventory.add(car2); // Blue Nissan Altima
		sInventory.add(car3); // Black Toyota Corolla
		sInventory.add(car4); // Red Honda Civic
		
		System.out.println(sInventory);
		
		System.out.println("\n***** Inventory with Comparator *****");
		Sedan.SedanColorComparator2 comparator = new Sedan.SedanColorComparator2();
		Set<Sedan> cInventory = new TreeSet<>(comparator);
		cInventory.add(car1); // Blue Nissan Altima
		cInventory.add(car2); // Blue Nissan Altima
		cInventory.add(car3); // Black Toyota Corolla
		cInventory.add(car4); // Red Honda Civic
		
		System.out.println(cInventory);
	}
	
	public static void maps() {
		// Maps are a data structure that function off key-value pairs
		// Dictionaries in other languages
		// Map is an interface just like List, Queue, and Dequeue (Stack)
		Map<String, String> birthdays = new HashMap<>();
		
		// my key is the name, my value is the birthday
		birthdays.put("Miles", "07/13");
		birthdays.put("Dan Pickles", "01/12");
		birthdays.put("Austin", "06/07");
		
		// sorts/ finds your keys based on their hashcode
		System.out.println(birthdays);
		
		// must like a list's get, where you search off the index. You can 
		// search a hashmap by key
		System.out.println(birthdays.get("Austin"));
		
		// can use a loop to print everything in a map's entryset
		// entrysets implement iterable, maps do not
		for (Map.Entry<String, String> entry : birthdays.entrySet()) {
			System.out.printf("Key: %s, Value: %s%n", entry.getKey(), entry.getValue());
		}
		
		// this will return null if nothing is there
		System.out.println(birthdays.get("Patrick"));
		System.out.println(birthdays.size());
		
		// i can change values in a map
		birthdays.replace("Dan Pickles", "01/20");
		System.out.println(birthdays);
		
		// does nothing if the key is not present
		birthdays.replace("Patrick", "05/12");
		System.out.println(birthdays);
		
		// can update values, but not keys
		birthdays.put("Pan Pickles", "01/12");
		System.out.println(birthdays);
		
		birthdays.remove("Pan Pickles");
		System.out.println(birthdays);
		
		// put overwrites what is there if the key already exists, else it adds it
		// in the case of duplicate keys it's called a "hashmap collision"
		birthdays.put("Miles", "08/18");
		System.out.println(birthdays);
		
		// maps allow duplicates, they just overwrite what was previously there
		Map<Sedan, Integer> inventory = new HashMap<>();
		Sedan car1 = new Sedan();
		Sedan car2 = new Sedan();
		Sedan car3 = new Sedan("Black", "Toyota", "Corolla");
		Sedan car4 = new Sedan("Red", "Honda", "Civic");
		
		inventory.put(car1, 1); // 1 nissan altima
		inventory.put(car3, 1); // 1 toyota corolla
		inventory.put(car4, 1); // 1 honda civic
		
		System.out.println(car1.equals(car2));
		System.out.println(car1.equals(new Sedan()));
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		
		inventory.put(car2, 2); // update nissan altimas to have 2 in stock, not 1
		// make and model are the key
		inventory.put(new Sedan("Purple", "Toyota", "Corolla"), 4);
		System.out.println(inventory);
		
		// if i want sorting to happen i can use a TreeMap
		// Hashmap uses the hash, tree map sorts based on a comparable
		Map<String, String> sBirthdays = new TreeMap<>();
		
		sBirthdays.put("Miles Mixon", "07/13");
		sBirthdays.put("Dan Pickles", "01/20");
		sBirthdays.put("Austin Reeves", "06/07");
		
		System.out.println(sBirthdays);
		
		System.out.println("\n**** Inventory with Comparable****");
		// HashMaps are unsorted while TreeMaps are sorted. Either based on a comparable or
		// a comparator
		Map<Sedan, Integer> sInventory = new TreeMap<>();
		sInventory.put(car1, 2); // nissan altima
		sInventory.put(car3, 1); // toyota corolla
		sInventory.put(car4, 1); // honda civic
		
		System.out.println(sInventory);
		
		System.out.println("\n**** Inventory with Comparator ****");
		Sedan.SedanColorComparator2 comparator = new Sedan.SedanColorComparator2();
		Map<Sedan, Integer> cInventory = new TreeMap<>(comparator);
		cInventory.put(car1, 2); // blue nissan altima
		cInventory.put(car3, 1); // black toyota corolla
		cInventory.put(car4, 1); // red honda civic
		
		System.out.println(cInventory);
	}
	
	public static void moreDataStructures() {
		// Stack vs Queue
		
		// Similar to a stack of plates
		// Last In, First Out (LIFO)
		// Stack is legacy, Java uses the Deque interface
		// commonly uses a linked list under the hood
		Deque<String> stack = new LinkedList<>();
		
		// you push elements onto a stack
		stack.push("First");
		stack.push("Second");
		stack.push("Third");
		
		System.out.println(stack);
		
		// if i dont want to print the whole thing
		// but still want to see what is ontop of my stack
		System.out.println(stack.peek());
		
		// peek does not remove that element
		System.out.println(stack);
		
		// if i want to get the element from the stack
		String lastElement = stack.pop(); // third
		System.out.println(lastElement); // removes it from the stack
		
		System.out.println(stack);
		
		lastElement = stack.pop(); // second
		System.out.println(lastElement);
		
		System.out.println(stack);
		
		lastElement = stack.pop(); // first
		System.out.println(lastElement);
		
		System.out.println(stack);
		
		stack.push("Another element");
		
		System.out.println(stack);
		
		stack.pop();
		
		// stacks will throw an exception if you pop and there is no element there
		// NoSuchElementException
		//stack.pop(); // empty stack here
		
		stack.push("Jim");
		stack.push("Bob");
		stack.push("Megan");
		stack.push("Ron");
		stack.push("Don");
		stack.push("Dan Pickles");
		
		while(stack.peek() != null) { // peek does not remove it
			int place = stack.size();
			String name = stack.pop(); // pop removes the element
			System.out.println(place + ". " + name);
		}
		
		System.out.println("***** Queues *****");
		// opposite of a stack is a queue, think of a line for a restaurant
		// First In, First Out (FIFO)
		// also commonly uses a LinkedList under the hood
		Queue<String> line = new LinkedList<>();
		
		// you push to a stack, not a queue
		// you offer to a queue
		line.offer("Dan Pickles");
		line.offer("Jon");
		line.offer("Miles");
		line.offer("Patrick");
		line.offer("John");
		line.offer("Erica");
		
		System.out.println(line);
		
		// stacks use peek to see what the top element is
		// queues use peek as well
		System.out.println(line.peek()); // does not remove anything still
		
		System.out.println(line);
		
		int place = 1;
		while (line.peek() != null) {
			// you pop from a stack, but you poll a queue
			String name = line.poll();
			System.out.println(place + ". " + name);
			place++;
		}
	}
	
	public static void genericClass() {
		// can hand anything to MyGenericand it works
		MyGeneric<String> myValue = new MyGeneric<String>("Miles");
		
		System.out.println(myValue.getA());
		
		MyGeneric<Integer> myValue2 = new MyGeneric<Integer>(10);
		
		System.out.println(myValue2.getA());
		
		MyGeneric<Float> myValue3 = new MyGeneric<Float>(63.2f);
		
		System.out.println(myValue3.getA());
		
		ArrayList<String> names = new ArrayList<>();
		names.add("Jeff");
		names.add("Blake");
		
		MyGeneric<ArrayList<String>> myList = new MyGeneric<ArrayList<String>>(names);
		
		System.out.println(myList.getA());
		
		// can setup generics that take in multiple values
		// the types dont matter as long as what i assign to a is always the first type
		// and what I assign to b is always the second type
		MyGeneric2<String, Integer> otherValue = new MyGeneric2<String, Integer>("Miles", 12);
		System.out.println(otherValue.getA());
		System.out.println(otherValue.getB());
		
		MyGeneric2<String, String> otherValue2 = new MyGeneric2<String, String>("Dan", "Pickles");
		System.out.println(otherValue2.getA());
		System.out.println(otherValue2.getB());
	}
	
	public static void customLinkedList() {
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		// works the same as with Integers
		MyLinkedList<String> myStrings = new MyLinkedList<>();
		
		myStrings.add("Bob");
		myStrings.add("Joe");
		myStrings.add("Megan");
		
		myStrings.print();
		
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		//myList.add("Car");
		myList.print();
		System.out.println("size: " + myList.getSize());
		
		System.out.println(myList.get(2));
		
		System.out.println("***** Insert Methods *****");
		myList.insert(2, 5);
		myList.print();
		
		myList.insert(5, 6);
		myList.print();
		
		try {
			myList.insert(9, 10);
		} catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		myList.insert(0, 7);
		myList.print();
		
		System.out.println("***** Remove Methods *****");
		try {
			myList.remove(20);
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
		myList.remove(2);
		myList.print();
		
		System.out.println("***** Set Methods *****");
		myList.set(4, 9);
		myList.print();
	}
	
	public static void linkedLists() {
		// two most common types of lists are
		// ArrayList
		// LinkedList
		
		// Both are Lists
		// keep in mind, List is an interface
//		List<Sedan> carAL = new ArrayList<>(); //car ArrayList
//		List<Sedan> carLL = new LinkedList<>(); //car LinkedList
		ArrayList<Sedan> carAL = new ArrayList<>();
		LinkedList<Sedan> carLL = new LinkedList<>();
		
//	    System.out.println(carLL.get(0));
//	    System.out.println(carAL.get(0));
		
		carAL.add(new Sedan());
		carAL.add(new Sedan("Black", "Honda", "Civic"));
		carAL.add(new Sedan("Grey", "Toyota", "Corolla"));
		
		carLL.add(new Sedan());
		carLL.add(new Sedan("Black", "Honda", "Civic"));
		carLL.add(new Sedan("Grey", "Toyota", "Corolla"));
		
		System.out.println(carAL);
		System.out.println(carLL);
		
		System.out.println(carAL.size());
		System.out.println(carLL.size());
		
		// LinkedList implements the List methods so we can give it an index
		// but it still traverses every element to get there
		// arraylist jumps straight to it
		System.out.println(carAL.get(1));
		System.out.println(carLL.get(1));
		
		// LinkedLists work differently than arraylists
		
		// ArrayList vs LinkedList
		/*
		 * ArrayList: 
		 * - Instant lookup time (indexed access)
		 * - slow inserts and deletes
		 * - continuous in memory
		 * - generally have more space than needed
		 * 
		 * LinkedList:
		 * - In Java, doubly linked
		 * - Slow lookups (no indexed access)
		 * - not continuous in memory
		 * - has exactly the space it needs
		 * - very fast inserts and deletes
		 */
		
		// cant use these with a List/ ArrayList. LinkedList specific
		System.out.println(carLL.peek());
		System.out.println(carLL.getLast());
		System.out.println(carLL.pop()); // removes the first element
		System.out.println(carLL);
	}
	
	public static void staticStuff() {
		Vehicle car1 = new Sedan(); // reference to a Vehicle
		Sedan car2 = new Sedan("Black", "Honda", "Civic"); // reference to a Sedan
		
		// instance methods look at the underlying type
		car1.honk();
		car2.honk();
		
		// static methods look at the reference type
		car1.drive();
		car2.drive();
	}
}
