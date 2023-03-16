package com.skillstorm.rehash;

// BetterPenguin is a child of BetterBird
// BetterBird is a parent of BetterPenguin
// BetterPenguin is a grandchild of BetterAnimal
public class BetterPenguin extends BetterBird {

	public BetterPenguin(String name, boolean fur, double weight, double speed, double wingspan) {
		// super() just calls the parent constructor
		// My parent has a constructor that sets all of this up for me, 
		// so I am letting it set it up for me. No need to type the same code twice
		super(name, fur, weight, speed, wingspan);
	}
	
	public void slide(int distance) {
		System.out.println(getName() + " slide for " + distance + " miles. Majestically");
	}
	
	public void dance() {
		System.out.println(getName() + " has happy feet");
	}
	
	// the same method as in BetterBird, exact same setup
	// but this is a BetterPenguin's version of it
	@Override
	public void speak() {
		System.out.println("HONK!");
	}
	
	@Override
	public void migrate() {
		dance();
		speak();
		// things are still inherited from the grandparent to the grandchild
		System.out.printf("%s is in the zone! It dances across the %s at %f mph!%n", 
				getName(), PLANET, getTopSpeed());
	}
}
