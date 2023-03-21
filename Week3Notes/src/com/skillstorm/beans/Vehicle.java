package com.skillstorm.beans;

// you can only have abstract methods inside of an abstract class
// abstract classes can also have non-abstract (concrete) 
public abstract class Vehicle {

	// these are not static final fields
	// in an interface these would be public static final
	private String color;
	private int topSpeed;
	private int wheels;
	private String size;
	
	// some methods depend on the extending class
	// in this case we are able to mark them as abstract, which means
	// I dont need to implement them here, but an extending class does
	
	// every car is gonna drive differently
	public abstract void drive();
	
	// probably very different to part an 18-wheeler vs a corolla
	public abstract void park();

	// most cars have a similar-ish horn
	public void honk() {
		System.out.println("Honk!");
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getTopSpeed() {
		return this.topSpeed;
	}
	
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public int getWheels() {
		return this.wheels;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public String getSize() {
		return this.size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
}