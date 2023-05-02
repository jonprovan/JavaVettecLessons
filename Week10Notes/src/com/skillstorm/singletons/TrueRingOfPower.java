package com.skillstorm.singletons;

// this implementation is thread safe
public class TrueRingOfPower {

	// still needs a private constructor
	// still need our static instance
	// still need our static getInstance method
	
	// we need something to lock on
	// because getInstance is a static method this object
	// also needs to be static
	private static Object mutex = new Object();
	
	private static TrueRingOfPower instance = null;
	
	private int abilities;
	
	private TrueRingOfPower() {
		this.abilities = 3;
	}
	
	private TrueRingOfPower(int abilities) {
		this.abilities = abilities;
	}
	
	public static TrueRingOfPower getInstance() {
		synchronized (mutex) {
			if (instance == null) {
				instance = new TrueRingOfPower();
			}
			
			return instance;
		}
	}
	
	public static TrueRingOfPower getInstance(int abilities) {
		// we only want one thread at a time to check the instance and
		// only want one thread at a time to create an instance
		synchronized (mutex) {
			if (instance == null) { //critical section
				instance = new TrueRingOfPower(abilities);
			}
			
			return instance;
		}
	}
	
	public int getAbilities() {
		return this.abilities;
	}
	
	public void invisibility() {
		System.out.println("Must have been the wind....");
	}
	
	public void superSpeed() {
		System.out.println("Kachow");
	}
	
	public void dominateWill() {
		System.out.println("This is not the code you're looking for....");
	}
}
