package com.skillstorm.rehash;

// extends keyword is used to inherit from a class
// BetterAnimal is the parent of BetterBird
// BetterBird is the child of BetterAnimal
// BetterBird IS A BetterAnimal
// Every class extends Object, no matter what
// A class can only extend one class
// Has no idea it has children, it is not concerned with them
public class BetterBird extends BetterAnimal {

	// static variables are shared in every instance of a class
	// they are all looking at the same value
	// these are tied to the class, not the instance
	private static int birdCount = 0;
	
	private double topSpeed;
	private double wingspan;
	
	public BetterBird() {
		// this is a no-args constructor. it takes no arguments
		birdCount++;
	}
	
	// because I defined this constructor I no longer have a default constructor
	public BetterBird(String name, boolean fur, double weight, double speed, double wingspan) {
		this.topSpeed = speed;
		this.wingspan = wingspan;
		// I inherited these methods and can use them to set the values
		setName(name);
		setFur(fur);
		setWeight(weight);
		birdCount++; // every time this constructor is called a new Bird is made
	}
	
	public void speak() {
		System.out.println("Chirp!");
	}
	
	public void feed(double amount) {
		System.out.println(getName() + " ate " + amount + " lbs");
	}
	
	// final methods are still inherited and work exactly the same way as
	// non-final methods. 
	// Except final methods cannot be overriden
	public final void flap(int times) {
		System.out.println(getName() + " flaped " + times + " times! It was glorious");
	}
	
	public void migrate() {
		flap(20);
		speak();
		System.out.println(getName() + " flew like the wind! At " + topSpeed + " mph.");
	}
	
	// no setter, so the only way I can change the birdCount is by making a new bird
	// this is static so tied to the class
	public static int getBirdCount() {
		return birdCount;
	}
	
	public double getTopSpeed() {
		return this.topSpeed;
	}
	
	public void setTopSpeed(double topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public double getWingspan() {
		return this.wingspan;
	}
	
	public void setWingspan(double wingspan) {
		this.wingspan = wingspan;
	}
	
	// this annotation lets the compiler check behind me and make sure I am 
	// overriding properly
	// toString() is a method from Object, every class inherits from Object
	// the signature is the same for overrides
	// has to be declared exactly the same as the one in the parent class
	@Override
	public String toString() {
		return "I am " + getName() + ". I have " + wingspan + " inch wings.";
	}
}
