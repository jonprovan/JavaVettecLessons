package com.skillstorm.rehash;

// everything in Java lives inside of a class
// seperate out your concerns: your classes only worry about their own functionality
public class BetterAnimal {

	// encapsulate your classes
	// encapsulation has two parts
	// 1. private/ protected properties
	// 2. public getters and setters
	private String name;
	private boolean fur;
	private double weight;
	// final means that the variable can never change
	// best practice is to capitalize final values
	public final String PLANET = "Earth";
	
	// everything has an access modifier
	// public - everything, everywhere can access this
	// protected - the class, the same package, and within a subclass
	// default - the class or the same package
	// private - the class
	
	// I have not defined a constructor here, so I have the default constructor
	// the default constructor calls object's constructor
	
	// "this" refers to the current instance of a class
	// it's the same as the class saying "MY name, or MY weight, etc"
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isFur() {
		return this.fur;
	}
	
	public void setFur(boolean fur) {
		this.fur = fur;
	}
}
