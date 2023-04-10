package com.skillstorm.beans;

public class Vehicle {

	// possible vehicle colors
	// Blue, Red, Green, Black, White, Orange
	// enum type - Allows me to specify possible values for a user to choose from
	// can function very similarly to a class, but are generally not used that way
	// generally used a custom type
	// these values are static final, so they are accessed through the enum type (ex/ Color.BLUE)
	public enum Color {
		BLUE,
		RED,
		GREEN,
		BLACK,
		WHITE,
		ORANGE
	}
	
	private String color;
	private String make;
	private String model;
	private Color colorV2;
	
	public Vehicle(Color color, String make, String model) {
		this.colorV2 = color;
		this.make = make;
		this.model = model;
		this.color = "Blue";
	}
	
	// valid constructor
	public Vehicle(String color, String make, String model) {
		//super(); // the first line is always a parent constructor call
		this.color = color;
		this.make = make;
		this.model = model;
		this.colorV2 = Color.WHITE;
	}
	
	public static void drive() {
		System.out.println("Vroom");
	}
	
	public void honk() {
		System.out.println("Beep");
	}
	
	public Color getColorV2() {
		return this.colorV2;
	}
	
	public void setColorV2(Color color) {
		this.colorV2 = color;
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
		return "[Vehicle: " + color + ", " + make + ", " + model + ", " + colorV2 + " ]";
	}
}
