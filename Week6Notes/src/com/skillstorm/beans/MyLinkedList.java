package com.skillstorm.beans;

// Generics
// They are a placeholder
// Generics can be any class, but not a primitive
public class MyLinkedList<T> { // <> tell Java that this is a Generic
	// generally denotes by
	// T - Type
	// E - Elements
	// K - Keys
	// N - Numbers
	// V - Value
	
	// can use any of the above to denote a Generic, the letter used
	// does not matter
	
	// rough implementation of a singly Linked List
	private Node head; // first element in the Linked List
	private Node tail; // need this so i dont need to traverse everytime i add something to the end
	private int size;
	
	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(T t) {
		// t = something the user wants to add, has to be the same type they defined
		//     earlier
		
		//am i  adding to the head (size == 0) or tail (size != 0)
		if (size == 0) {
			// adding the head
			Node n = new Node(t);
			head = n; // set the head to this new node
			tail = n; // this node is the first, and only thing right now
			size++;
		} else {
			Node n = new Node(t);
			tail.next = n;
			tail = n;
			size++;
		}
	}
	
	public T get(int index) {
		// can't jump to it. have to go through each element
		
		if (index >= size || index < 0) {
			// if the index is greater than the size, it doesnt exist
			throw new IndexOutOfBoundsException("" + index);
			// convert the above into a string
		}
		
		Node current = head; // need to start at the beginning
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.data;
	}
	
	public void insert(int index, T value) {
		if (index == size) {
			// really just inserting something a the end, exactly like my add method does
			add(value);
		} else if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("" + index);
		} else {
			if (index == 0) {
				// adding something to the beginning
				Node n = new Node(value);
				n.next = head;
				head = n;
				size++;
			} else {
				// if im not adding it to the beginning
				Node n = new Node(value); // my new thing
				Node current = head;
				
				// need to stop before the index I want it at so it adds properly
				for (int i = 0; i < index-1; i++) {
					current = current.next;
				}
				
				Node next = current.next;
				current.next = n;
				n.next = next;
				size++;
			}
		}
	}
	
	public void set(int index, T value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("" + index);
		} else {
			Node current = head;
			
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			
			current.data = value;
		}
	}
	
	public void remove(int index) {
		if (index == 0) {
			// we're removing the first element
			// our new head is whatever was after head
			head = head.next;
			size--;
		} else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("" + index);
		} else {
			Node current = head;
			
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			
			// the value after, the value after current
			// ex/ index 1 == current and index 3 == next
			//     want to remove index 2
			current.next = current.next.next;
//			Node newNext = current.next.next;
//			current.next = newNext;
			size--;
		}
	}
	
	public void print() {
		Node current = head;
		
		// print the first element
		System.out.print("[ " + head.data);
		current = current.next;
		
		// if there are still elements, comma separate them
		while (current != null) {
			// null is the end of my linked list
			System.out.print(", " + current.data);
			current = current.next;
		}
		
		// close the output
		System.out.println(" ]");
	}
	
	// ill keep track of the size
	public int getSize() {
		return this.size;
	}
	
	// inner class, only useable within MyLinkedList
	// because its only useable by MyLinkedList there isnt much of a reason to
	// use getters and setters here
	private class Node {
		private Node next; // each node knows where the next one in the chain is
		private T data; // each node knows what it's data is
		
		public Node(T t) {
			next = null;
			data = t;
		}
	}
}
