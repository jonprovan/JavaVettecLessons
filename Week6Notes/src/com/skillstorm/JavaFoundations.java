package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		genericClass();
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
