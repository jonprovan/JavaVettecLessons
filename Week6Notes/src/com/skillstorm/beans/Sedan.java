package com.skillstorm.beans;

import java.util.Comparator;

public class Sedan extends Vehicle implements Comparable<Sedan> { // replace T with the class name

	private String owner = "Dan Pickles";
	
	// you can also use the this() keyword to call any of your constructors
	public Sedan() {
		// need to call a valid parent constructor or the method is wrong
		//super("Blue", "Nissan", "Sentra");
		
		// first line has to be either this() or super(). the this() replaces the super
		this("Blue", "Nissan", "Altima"); // refers to my constructor on line 20
	}
	
	// Java always uses the super() keyword in your constructors
	// Java always makes a call to the parent constructor, this is called constructor chaining
	public Sedan(String color, String make, String model) {
		//System.out.println("Yay"); the super() or this() has to be the first line of code
		super(color, make, model); // I need to call a valid parent constructor
	}	
	
	public static void drive() {
		System.out.println("Zoom Zoom");
	}
	
	@Override
	public void honk() {
		System.out.println("Beep Beep");
	}
	
	// if you want to compare two object for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (this.getClass() != obj.getClass()) {
			return false;
		}
		
		Sedan other = (Sedan)obj;
		return this.getMake() == other.getMake() && 
				this.getModel() == other.getModel();
	}
	
	// now if i  want to be able to order object (say one is > or < another object)
	// i use the comparable interface
	// when you implement the comparable interface you have to tell it the object's type
	// you replace the T with the type, you still need the < >.
	// in order to implement it you need to override 1 method
	@Override
	public int compareTo(Sedan other) {
		// this method is used in sorting
		// comparing based off 0
		// if result < 0, then other goes after this
		// if result > 0, then other goes before this
		// if result = 0, then they are the same
		
		// in our case we are probably alphabetizing based off make and model
		// so we can use String's compareTo to alphabetize it
		String thisString = this.getMake() + " " + this.getModel();
		String otherString = other.getMake() + " " + other.getModel();
		
		return thisString.compareTo(otherString);
	}
	
	// nested classes - class inside of another class
		// only really useful if the inner class is something the outer class alone needs
		// a way to group related classes
		// your inner class (SedanColorComparator) is FULLY dependent on the outer class (Sedan)
	
	// what if i want a different way to compare these?
	// what if i want multiple ways to compare?
	// need a nested class for this, dont need, but a bit easier with one
	public class SedanColorComparator implements Comparator<Sedan> {
		// can set up comparisons uses the Comparator interface
		
		// method only really makes sense when the class isnt static
		public void method() {
			// can't use this to access these, but I can access sedna's methods from here
			// sedan's properties are still accessible within an inner class
			System.out.println(getColor());
			System.out.println(getMake());
			System.out.println(getModel());
			System.out.println(owner); // can even grab private things here
			System.out.println("Inside the inner class");
		}
		
		@Override
		public int compare(Sedan sedan1, Sedan sedan2) {
			// sorts alphabetically by color
			return sedan1.getColor().compareTo(sedan2.getColor());
		}
	}
	
	// nested classes - class inside of another class
		// only really useful if the inner class is something the outer class alone needs
		// a way to group related classes
		// your inner class (SedanColorComparator) is FULLY dependent on the outer class (Sedan)
			//your inner class cannot be instantiated until the outer class has been instantiated
	
	// static nested class - exactly the same as a non-static one except you dont need a version
		// of the outer class to exist to make the inner one
	public static class SedanColorComparator2 implements Comparator<Sedan> {

		@Override
		public int compare(Sedan o1, Sedan o2) {
			// sorts alphabetically by color
			return o1.getColor().compareTo(o2.getColor());
		}
	}
}
