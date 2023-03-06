package com.skillstorm.general;

// Methods
public class Day1 {

	
	// this is a method
	// this method is the entry point every application
	// methods need to exist inside of a class
	// anything that stems from main runs, if main does not lead to it, it does not run
	public static void main(String[] args) {
		print("Hello World");
		
		System.out.println("We're calling methods today");
		System.out.println("This is a method, this is the print method");
		
		// to call the method I need the signature and any parameters
		print("Not the tabs!");
	}
	
	// the order of defining/declaring these does not matter
	public static void print(String message) {
		// public = accessor/ access modifier
		// static = modifier
		// void = return type
		// print = method name (part of the signature)
		// (String message) = parameter (other part of the signature)
		// {} = method body
		
		// methods can call other methods
		System.out.println(message);
	}
}
