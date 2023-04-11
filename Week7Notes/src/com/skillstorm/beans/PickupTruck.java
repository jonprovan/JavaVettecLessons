package com.skillstorm.beans;

public class PickupTruck implements Truck {

	// nothing stopping me from overriding a method that is defualt,
	// but it is now optional to override it
	@Override
	public void tow(String payload) {
		System.out.println("Towed a " + payload + " along a dirt road.");
	}
}
