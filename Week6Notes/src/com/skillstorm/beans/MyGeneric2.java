package com.skillstorm.beans;

// generally denoted by
// T - Type
// E - Elements
// K - Keys
// N - Numbers
// V - Value
public class MyGeneric2<T, V> {

	private T a; // no idea what a will be
	private V b;
	
	public MyGeneric2(T a, V b) {
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
	public V getB() {
		return this.b;
	}
	
	public void setB(V b) {
		this.b = b;
	}
}
