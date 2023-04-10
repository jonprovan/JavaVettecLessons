package com.skillstorm.beans;

public class Vehicle {

	private String color;
	private String make;
	private String model;
	
	// valid constructor
	public Vehicle(String color, String make, String model) {
		//super(); // the first line is always a parent constructor call
		this.color = color;
		this.make = make;
		this.model = model;
	}
	
	public static void drive() {
		System.out.println("Vroom");
	}
	
	public void honk() {
		System.out.println("Beep");
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "[Vehicle: " + color + ", " + make + ", " + model + " ]";
	}
}
