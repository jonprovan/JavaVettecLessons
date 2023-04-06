package com.skillstorm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
		maps();
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
		birthdays.put("Miles", "08/18");
		System.out.println(birthdays);
		
		// maps allow duplicates, they just overwrite what was previously there
		Map<Sedan, Integer> carMileage = new HashMap<>();
		Sedan car1 = new Sedan();
		Sedan car2 = new Sedan();
		Sedan car3 = new Sedan("Black", "Toyota", "Corolla");
		Sedan car4 = new Sedan("Red", "Honda", "Civic");
		
		// if i have a hashcode method then there are 3 cars here, if i dont there are 4
		carMileage.put(car1, 100000);
		carMileage.put(car2, 1000);
		carMileage.put(car3, 124632);
		carMileage.put(car4, 423190);
		System.out.println(carMileage);
		
		carMileage.put(new Sedan(), 2000);
		System.out.println(carMileage);
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
