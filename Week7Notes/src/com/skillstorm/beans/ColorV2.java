package com.skillstorm.beans;

import com.skillstorm.beans.Vehicle.Color;

public enum ColorV2 {

	// constant values here must be the first thing
	BLUE("Blue"),
	RED,
	GREEN("Green"),
	BLACK("Black"),
	WHITE("White"),
	PURPLE("Purple"),
	ORANGE("Orange"),
	YELLOW("Yellow"); // when defining more than just the types I need a semi-colon here
	
	// in Java enum types are essentially classes
	// generally you dont use them this way and use them for static types,
	// but they offer a lot of customization
	
	private final String color;
	
	// can have constructors, can even overload them
	ColorV2() {
		this.color = "Red";
	}
	
	ColorV2(String color) {
		this.color = color;
	}
	
	public String color() {
		return color;
	}
	
	// can have methods as well
	public String superIt() {
		return "Super " + this.color;
	}
	
	// can even have a main here
	public static void main(String[] args) {		
		for (ColorV2 c : ColorV2.values()) {
			System.out.println(c + " -> " + c.superIt());
		}
	}
}
