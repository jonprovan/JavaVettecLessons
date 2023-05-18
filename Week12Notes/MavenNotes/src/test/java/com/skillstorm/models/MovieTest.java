package com.skillstorm.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

// Test files go into src/test/java
// they run separately from the rest of your code
// they are built separately. You dont ship your tests with your code
public class MovieTest {
	
	// Unit test are used to test small pieces of your code, so individual methods usually

	// Maven is able to use these test classes to test my code as i build the project
	// if the tests fail it fails my build
	// JUnit is a test framework that works with java
	// it works off of annotations, the annotations tell JUnit what to do
	// @Test tells JUnit this is a unit test
	@Test
	public void checkAdmission() {
		// need an instance of the object we are testing
		Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Action", 6.2);
		
		// these still work in test methods, 
		// but you generally check the test output, instead of the console
		System.out.println("My message");
		
		// in test methods you use Asserts to check that conditions are true or false
		// if the assertion passes then your test passes, if the assertion fails, your test also
		// fails
		// you can have as many assertions as you would like
		assertTrue(actionMovie.checkAdmission(21));
		assertFalse(actionMovie.checkAdmission(8));
		assertFalse(actionMovie.checkAdmission(7));
		assertTrue(actionMovie.checkAdmission(18));
		assertEquals(true, actionMovie.checkAdmission(14));
	}
}
