package com.skillstorm.beans;

public class Eagle extends Bird {

	public Eagle() { }
	
	public Eagle(String name, String color, boolean carnivore, boolean fly, double topSpeed) {
		super(name, color, carnivore, fly, topSpeed);
	}
	
	// overriding
	// same method signature, but different method from the one we inherit
	@Override
	public void speak() {
		System.out.println("KAWWWW!");
	}
}
