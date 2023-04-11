package com.skillstorm.beans;

public interface Truck {

	// can use the default keyword to provide a default implementation for a method
	// allows you to define functionality in an interfaces
	// any fields are still public static final
	public default void tow(String payload) {
		System.out.println("Towed a " + payload);
	}
	
	public default void tow(String payload, double distance) {
		System.out.println("Towed a " + payload + " " + distance + " miles.");
	}
	
	// can also have static methods, also need to define functionality here
	public static void haul(int amt, String payload) {
		System.out.println("Hauled " + amt + " " + payload + "s");
	}
}
