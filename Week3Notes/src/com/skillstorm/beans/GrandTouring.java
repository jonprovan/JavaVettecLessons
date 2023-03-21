package com.skillstorm.beans;

public class GrandTouring extends Motorcycle {

	public GrandTouring(String brand, String model, String color, int topSpeed, 
			String size, boolean trike) {
		// we can pass this information to our parent constructor
		super(brand, model, color, topSpeed, size, trike);
	}
	
	@Override
	public void drive() {
		System.out.println("Vroom!");
	}

	@Override
	public void park() {
		// because parking is just driving in reverse
		System.out.println("moorV!");
	}
	
	public void saddleBags(String object) {
		System.out.println("Storing a " + object + " in my saddle bag");
	}

	@Override
	public String toString() {
		return String.format("%s %s %s with %d wheels", getColor(), getBrand(), 
				getModel(), getWheels());
	}
}
