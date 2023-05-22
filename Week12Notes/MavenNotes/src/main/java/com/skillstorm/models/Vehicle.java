package com.skillstorm.models;

public class Vehicle {
	
	private String make;
	private String model;
	private String color;
	private int year;
	private int gas;

	public Vehicle(String make, String model, String color, int year, int gas) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.gas = gas;
	}
	
	public String drive(int distance) {
		return "Drove " + distance + " Miles";
	}
	
	public boolean turn(String direction) throws Exception {
		if (direction.trim().equalsIgnoreCase("left")) {
			return true;
		} else if (direction.trim().equalsIgnoreCase("right")) {
			return false;
		} else {
			throw new Exception();
		}
	}
	
	public String honk() {
		return "HONK!!!";
	}
	
	public boolean checkGas(int lvl) {
		return this.gas >= lvl;
	}
}
