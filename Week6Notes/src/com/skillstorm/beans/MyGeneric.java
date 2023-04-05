package com.skillstorm.beans;

// this is a generic wrapper class
// it can take in any class as a type for a
public class MyGeneric<T> {
	// generally denoted by
	// T - Type
	// E - Elements
	// K - Keys
	// N - Numbers
	// V - Value
	private T a; // no idea what a will be
	
	public MyGeneric(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
}
