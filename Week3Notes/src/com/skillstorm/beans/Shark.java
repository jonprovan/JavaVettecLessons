package com.skillstorm.beans;

import com.skillstorm.general.ImATeapotException;

// interfaces need to use the interface keyword
// cannot be final
// the only valid keywords are public and abstract
// everything that isnt static in an interface is abstract
public interface Shark {

	// any variable in an interface is public static final
	String type = "Fish";
	
	// these methods are abstract
	// they have no implementation
	// but garanteed every Shark will have an implementation of these
	public void swim(double distance) throws CloneNotSupportedException;
	public void bite() throws ImATeapotException; // abstract methods can throw exceptions
	public void hunt();
}
