package com.skillstorm.stackassignemnt;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {

	ArrayList<T> elements;
	
	public Stack() {
		elements = new ArrayList<>();
	}
	
	public void push(T element) {
		elements.add(element);
	}
	
	public T pop() {
		if (elements.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return elements.remove(elements.size()-1);
	}
	
	public T peek() {
		if (elements.isEmpty()) {
			return null;
		} else {
			return elements.get(elements.size() - 1);
		}
	}
	
	public int size() {
		return elements.size();
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
}
