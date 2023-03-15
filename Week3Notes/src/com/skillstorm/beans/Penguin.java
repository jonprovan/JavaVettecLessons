package com.skillstorm.beans;

public class Penguin extends Bird {
	
	public Penguin() { }
	
	public Penguin(String name, String color, boolean carnivore, boolean fly, double topSpeed) {
		super(name, color, carnivore, fly, topSpeed);
	}
	
	// the final keyword on methods, stops the method form being overriden
	public final void dance() {
		System.out.println(getName() + " has happy feet");
	}

	public void slide(double distance) {
		System.out.println(getName() + " slid " + distance + " miles, majesticaly!");
	}
	
	@Override
	public void speak() {
		System.out.println("HONK!");
	}
	
	@Override
	public void migrate() {
		dance();
		super.speak(); // this calls the method in the parent class
		System.out.println(getName() + 
				" is in the zone. It dances across the land at " + getTopSpeed() + 
				" mph");
	}
	
	@Override
	public String toString() {
		return "I am " + getName() + " and I have the happiest of feet. I can dance at "
					+ getTopSpeed() + " mph.";
	}
}
