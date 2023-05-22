package com.skillstorm.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TDD or Test Driven Development is where you write all of your tests then you write the code
// that makes those tests pass
public class VehicleTest {

	Vehicle testCar;
	
	@Before
	public void setup() {
		// "Make, Model, Color, Year, Gas"
		testCar = new Vehicle("Honda", "Civic", "Red", 2002, 70);
	}
	
	// Drive
	@Test
	public void driveDistanceWorks() {
		assertTrue(testCar.drive(21).equalsIgnoreCase("Drove 21 Miles"));
		assertTrue(testCar.drive(15).equalsIgnoreCase("Drove 15 Miles"));
		assertTrue(testCar.drive(45).equalsIgnoreCase("Drove 45 Miles"));
	}
	
	// Turn
	@Test
	public void vehicleCanSometimesTurn() throws Exception {
		assertTrue(testCar.turn("Left"));
		assertFalse(testCar.turn("Right"));
		assertTrue(testCar.turn("LeFt"));
		assertFalse(testCar.turn("RIgHt"));
		//assertFalse(testCar.turn(""));
	}
	
	// If i want to test for a failure of some sort, like an exception being thrown
	@Test(expected = Exception.class) // I can tell my test to expect the exception
	public void vehicleTurnThrowsException() throws Exception {
		testCar.turn("");
	}
	
	// Honk
	@Test
	public void vehicleCanHonk() {
		assertTrue(testCar.honk().equals("HONK!!!"));
	}
	
	// Check Gas
	@Test
	public void checkGasLevels() {
		assertTrue(testCar.checkGas(20));
		assertTrue(testCar.checkGas(65));
		assertFalse(testCar.checkGas(85));
	}
	
	@After
	public void teardown() {
		testCar = null;
	}
}
