package com.skillstorm.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// Test files go into src/test/java
// they run separately from the rest of your code
// they are built separately. You dont ship your tests with your code
public class MovieTest {
	
	Movie actionMovie;
	
	// this is something you want to run just once before anything else is run
	// this method has to be static
	@BeforeClass
	public static void init() {
		// where you would run code you only need once like creating a database
		System.out.println("inside before class");
	}
	
	// if there was some setup i needed before each test I can create a method for that
	@Before
	public void setup() {
		// something like creating fresh data in a database table
		System.out.println("inside setup");
		
		// this creates this new action movie just before each of the below tests runs
		actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Sci-Fi Action", 6.2);
	}
	
	// Unit test are used to test small pieces of your code, so individual methods usually

	// Maven is able to use these test classes to test my code as i build the project
	// if the tests fail it fails my build
	// JUnit is a test framework that works with java
	// it works off of annotations, the annotations tell JUnit what to do
	// @Test tells JUnit this is a unit test
	@Test
	public void checkAdmission() {
		// need an instance of the object we are testing
		//Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Action", 6.2);
		
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
	
	// the order that Test methods run in is not gauranteed
	// test should be self contained and not written to rely on a test order
	@Test
	public void checkRuntime() {
		//Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Action", 6.2);
		
		assertTrue(actionMovie.isTime(130));
		assertFalse(actionMovie.isTime(20));
		assertEquals(true, actionMovie.isTime(118));
	}
	
	@Test
	public void checkMovieSubgenresReturnsTrue() {
		// comparing genres so i am changing the genre
		//Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Sci-Fi Action", 6.2);
		Movie actionMovie1 = new Movie("47 Ronin", 2013, "PG-13", 118, "Action Romance", 6.2);
		Movie actionMovie2 = new Movie("47 Ronin", 2013, "PG-13", 118, "Action Comedy", 6.2);
		
		assertTrue(actionMovie.isGenre("Action"));
		assertTrue(actionMovie1.isGenre("aCtIoN"));
		assertTrue(actionMovie2.isGenre("ACTion"));
	}
	
	@Test
	public void checkCompareReviews() {
		// comparing the reviews, so changing the review scores
		//Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Sci-Fi Action", 6.2);
		Movie actionMovie1 = new Movie("47 Ronin", 2013, "PG-13", 118, "Action Romance", 7.2);
		Movie actionMovie2 = new Movie("47 Ronin", 2013, "PG-13", 118, "Action Comedy", 5.2);
		
		assertTrue(actionMovie.compareReviews(actionMovie2));
		assertTrue(actionMovie1.compareReviews(actionMovie));
		assertFalse(actionMovie2.compareReviews(actionMovie));
	}
	
	// this does the opposite of the Before annotation and runs after each of your test methods
	@After
	public void teardown() {
		System.out.println("inside teardown");
		
		actionMovie = null;
	}
	
	// can have multiple before and after methods, but the order is not gauranteed
	@After
	public void teardown2() {
		System.out.println("after 2");
	}
	
	// runs once after every test method in your class runs
	// so something like deleting your test database
	// also has to be a static method
	@AfterClass
	public static void cleanUp() {
		System.out.println("inside after class");
	}
}
