package com.skillstorm.singletons;

// this is not thread safe
public class RingOfPower {

	// we need a property every instance of this class will have that represents
	// the single instance we want to create
	// we dont provide setters for our instance
	private static RingOfPower instance = null;
	private int abilities;
	
	// singletons are made using a
	// private constructor
	// cannot use the default constructor because the default 
	// constructor is public
	private RingOfPower(int abilities) {
		this.abilities = abilities;
	}
	
	// to make an instance of this, users need to go through a public static method
	// instead of the constructor
	public static RingOfPower getInstance(int abilities) {
		// if this constructor was not called instance will be null
		// otherwise return the instance that was already created
		if (instance == null) {
			instance = new RingOfPower(abilities);
		}
		
		return instance;
	}
	
	public int getAbilities() {
		return this.abilities;
	}
	
	public void invisibility() {
		System.out.println("Must have been the wind....");
	}
	
	public void superSpeed() {
		System.out.println("Kachow");
	}
	
	public void dominationOfWill() {
		System.out.println("This is not the code you're looking for....");
	}
}
