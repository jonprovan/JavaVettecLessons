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
	
	public void print() {
		Node current = head;
		
		while (current != null) {
			// null is the end of my linked list
			System.out.println(current.data);
			current = current.next;
		}
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
