package com.skillstorm.stackassignment2;

import java.util.EmptyStackException;

public class Stack<T> {

	private Node top;
	private int length;
	
	public Stack() {
		top = null;
		length = 0;
	}
	
	public void push(T element) {
		Node n = new Node(element);
		n.next = top;
		top = n;
		length++;
	}
	
	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		
		Node temp = top;
		top = top.next;
		length--;
		
		return temp.data;
	}
	
	public T peek() {
		if (top == null) {
			return null;
		} else {
			return top.data;
		}
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmtpy() {
		return length == 0;
	}
	
	private class Node {
		private Node next;
		private T data;
		
		public Node(T t) {
			next = null;
			data = t;
		}
	}
}
