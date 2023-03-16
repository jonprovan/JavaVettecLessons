package com.skillstorm.rehash;

public class BetterZoo {

	public static final String MASTERZOOLOGIST = "Anthony";
	
	// every single program starts here
	// all your programs do is run the steps in main
	public static void main(String[] args) {
		// anything static exists from the moment your program starts, that's
		// why they are tied to a class, not an instance
		System.out.println(MASTERZOOLOGIST);
		
		System.out.println("****** Carl *******");
		// new keyword calls a constructor
		// the arguments I hand my constructor have to match one of my defined constructors
		BetterBird carl = new BetterBird("Carl", false, 500, 10, 4);
		carl.speak();
		carl.feed(250);
		carl.flap(1);
		carl.migrate();
		System.out.println(BetterBird.getBirdCount());
		
		System.out.println("****** Bob *******");
		// I have inherited all of the methods from BetterBird
		BetterPenguin bob = new BetterPenguin("Bob", true, 120, 75.5, 70);
		bob.speak();
		bob.feed(120);
		bob.flap(30);
		bob.migrate();
		
		//I also have access to any methods specific to BetterPenguin
		bob.dance();
		bob.slide(42);
		
		System.out.println(BetterBird.getBirdCount());
		// this is the incorrect way to reference a static property, it is
		// tied to the class not the instance
		// All 3 have the same value, because all 3 are the exact same variable
		System.out.println(bob.getBirdCount());
		System.out.println(carl.getBirdCount());
		
		System.out.println("****** Terry *******");
		BetterEagle terry = new BetterEagle("Terry", false, 95, 240, 85);
		terry.speak();
		terry.feed(350);
		terry.flap(18);
		terry.migrate();
		
		System.out.println(BetterBird.getBirdCount());
		
		System.out.println("***** Jerry *******");
		// can only use this because I made a no arguments constructor
		BetterBird jerry = new BetterBird();
		jerry.setName("Jerry");
		jerry.setFur(true);
		jerry.setWeight(15);
		jerry.setTopSpeed(25);
		jerry.setWingspan(9);
		
		jerry.speak();
		jerry.feed(65);
		jerry.flap(50);
		jerry.migrate();
		
		System.out.println(BetterBird.getBirdCount());
	}
}
