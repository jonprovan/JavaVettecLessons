package com.skillstorm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.skillstorm.beans.MyLinkedList;
import com.skillstorm.beans.Sedan;
import com.skillstorm.beans.Vehicle;

public class JavaFoundations {

	public static void main(String[] args) {
		//staticStuff();
		//linkedLists();
		customLinkedList();
	}
	
	public static void customLinkedList() {
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.print();
		System.out.println("size: " + myList.getSize());
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
