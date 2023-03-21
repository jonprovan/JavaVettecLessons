package com.skillstorm.beans;

// similar to implementing an interface, an abstract class/ interface requires that
// you implement all unimplemented methods or be abstract

// I do not implement the vehicle methods here, so it is abstract
public abstract class Motorcycle extends Vehicle {

	private String brand;
	private String model;
	
	// abstract classes can have constructors just like concrete classes
	
	// maybe i want to set the properties manually for
	// something like a slingshot or a v8
	public Motorcycle() { }
	
	// general purpose constructor
	public Motorcycle(String brand, String model, String color, int topSpeed, 
			String size, boolean trike) {
		this.brand = brand;
		this.model = model;
		setColor(color);
		setTopSpeed(topSpeed);
		setSize(size);
		
		// if trike is true, it has 3 wheels
		// else it has 2 wheels
		// trike is a flag, not a property
		// so we dont need to encapsulate it
		if (trike) {
			setWheels(3);
		} else {
			setWheels(2);
		}
	}
	
	// can still override methods in an abstract class
	@Override
	public void honk() {
		System.out.println("quiet honk");
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	// can use this to tell Java how to compare this object with other objects
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			// if their memory address are the same, safe to say they're equal
			return true;
		} else if (obj == null) {
			// if the other thing doesnt exist, safe to say these arn't equal
			return false;
		} else if (this.getClass() != obj.getClass()) {
			// if these are two different classes, safe to say they arn't equal
			return false;
		}
		
		// Object doesnt know what a Motorcycle is
		// Object is not aware of Motorcycle's method/ properties
		// This works for any subclass of motorcycle, because the subclasses are
		// also motorcycles, and due to the above comparison we also know they are
		// the same type of motorcycle
		Motorcycle other = (Motorcycle)obj;
		if (this.brand.equals(other.getBrand()) && this.model.equals(other.getModel())) {
			return true;
		} else {
			return false;
		}
	}
}
