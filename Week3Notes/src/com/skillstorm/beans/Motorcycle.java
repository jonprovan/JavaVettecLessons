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
}
