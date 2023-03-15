package com.skillstorm.beans;

// you inherit from classes with the extends keyword
// can only extend from one class
// classes can also be final. Nothing can extend/ inherit from a final class
public final class Ostrich extends Bird {

	public Ostrich() { }
	
	public Ostrich(String name, String color, boolean carnivore, boolean fly, double topSpeed) {
		// super is a special keyword used during inheritance
		// super allows you to use methods from the parent class
		// if you call super() that calls the parent class's constructor
		super(name, color, carnivore, fly, topSpeed);
	}
	
	public void hide(int duration) {
		System.out.println(getName() + " hides for " + duration + " hours.");
		System.out.println("If I can't see them, then they cant see me!");
	}
	
	@Override
	public void migrate() {
		flap(25);
		speak();
		System.out.println(getName() + " ran like the wind! At " + getTopSpeed() + " mph.");
	}
}
