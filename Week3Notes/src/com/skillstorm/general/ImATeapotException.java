package com.skillstorm.general;

// every exception needs to entend exception
// this is a custom exception
// all we need is to call the parent constructors, because they have all the functionality we
// really need
public class ImATeapotException extends Exception {
	
	public ImATeapotException() {
		super();
	}
	
	public ImATeapotException(String message) {
		super(message);
	}
}
