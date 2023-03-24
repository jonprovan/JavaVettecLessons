package com.skillstorm.general;

import java.rmi.server.ServerCloneException;

import com.skillstorm.beans.BaldEagle;
import com.skillstorm.beans.Bird;
import com.skillstorm.beans.BlackTip;
import com.skillstorm.beans.Eagle;
import com.skillstorm.beans.EmperorPenguin;
import com.skillstorm.beans.Fish;
import com.skillstorm.beans.Goblin;
import com.skillstorm.beans.GrandTouring;
import com.skillstorm.beans.HammerHead;
import com.skillstorm.beans.Motorcycle;
import com.skillstorm.beans.Ostrich;
import com.skillstorm.beans.Penguin;
import com.skillstorm.beans.Shark;
import com.skillstorm.beans.Sport;
import com.skillstorm.beans.Vehicle;

public class Zoo {

	// properties create a HAS-A relationship
	// a Zoo HAS-A name
	// a Zoo HAS-A address
	// a Zoo HAS-A master zoologist
	
	// this is a static variable
	public static String masterZoologist = "Anthony";
	
	// static and final are different
	// usually final variables are in all caps, to signal to anyone who uses
	// them that they are final
	public static final double TICKETPRICE = 74.99;
	
	// any variables within your class, that is not in a method
	// is a property
	public String name; // instance variable
	public String address; // instance variable
	
	// this will be our week 3 zoo
	// this will house our main method
	
	// static methods and properties are always available, they are loaded into
	// memory and made available when the program starts
	public static void main(String[] args) {
		// inside the same class I do not need a class name for method calls
		// two calls to the exact same method
		buyTickets(4);
		Zoo.buyTickets(3);
		
		// cannot do the same thing for instance methods
		// cannot directly call non-static methods from inside a static method
		//sellPopcorn();
		// this is a call to our zoo constructor
		Zoo phillyZoo = new Zoo();
		// with an instance of a class, you can call instance methods
		phillyZoo.sellPopcorn();
		
		Zoo nyZoo = new Zoo();
		nyZoo.sellPopcorn();
		
		// static variables can be called just like methods
		// static variables are shared across all instances
		System.out.println(masterZoologist); // only works in my zoo class
		System.out.println(Zoo.masterZoologist); // the proper way to call this
		// this property does not belong to the instance, so it doesnt like
		// me accessing it this way
		System.out.println(phillyZoo.masterZoologist);
		System.out.println(nyZoo.masterZoologist);
		
		phillyZoo.masterZoologist = "Dr. Anthony";
		System.out.println(phillyZoo.masterZoologist);
		System.out.println(nyZoo.masterZoologist);
		System.out.println(masterZoologist); // only works in my zoo class
		System.out.println(Zoo.masterZoologist); // the proper way to call this
		
		phillyZoo.name = "Philadelphia Zoo";
		nyZoo.name = "New York Zoo";
		
		System.out.println(phillyZoo.name);
		System.out.println(nyZoo.name);
		
		// created an animal with the default constructor
		// i can get the hashcode because it exists
		//Animal myAnimal = new Animal();
		// once I add a constructor the default one is no longer an option
		Animal myAnimal = new Animal("Mark", "Blue", 15, true);
		System.out.println(myAnimal);
		
		// can do this because it's public
		myAnimal.name = "Dan";
		
		// can do this because it's default and im in the same package
		myAnimal.color = "Grey";
		
		// can do this because it's protected and im in the same package
		myAnimal.age = 53;
		
		// cannot access fur here because it is private and I am not inside
		// the animal class
		//myAnimal.fur = true;
		
		// can use getters and setters to access these values
		myAnimal.setFur(true);
		System.out.println(myAnimal.hasFur());
		
		//phillyZoo.birdExhibit();
		//phillyZoo.sharkExhibit();
		//phillyZoo.rideBike();
		phillyZoo.polymorphism();
	}
	
	public static void buyTickets(int num) {
		double amount = num * (TICKETPRICE * 1.06);
		
		// format is a static method of the String class
		// static methods are called with the class name, not the instance
		System.out.println(String.format("That will be $%.2f", amount));
	}
	
	// not zoo related. this is the 4th pillar of OOP
	// polymorphism means many forms
	// things like our overrides and our overloads
	// things likes covariance
	public void polymorphism() {
		// both of these variables are vehicles and both have a drive method
		Vehicle bike1 = new Sport("Suzuki", "Hayabusa", "Black", 180, "Medium", false);
		Vehicle bike2 = new GrandTouring("Suzuki", "Boulevard C50T", "White", 110, "Small", false);
		
		// I have overriden vehicle's drive method, so each call prints a different thing
		// the drive method has many forms (is polymorphic)
		bike1.drive();
		bike2.drive();
		
		Sport sportBike = (Sport) bike1;
		sportBike.drive(4);
		
		GrandTouring touringBike = new GrandTouring("Suzuki", "Boulevard C50T", "Purple", 110, "Small", false);
		
		Vehicle[] myBikes = new Vehicle[4];
		myBikes[0] = bike1;
		myBikes[1] = bike2;
		myBikes[2] = sportBike;
		myBikes[3] = touringBike;
		
		System.out.println("***** Bike Comparisson *****");
		for (int i = 0; i < myBikes.length; i++) {
			// Java knows the types, it can check while running, but is not
			// entirely sure until the code is run

			// returns a true/ false
			//System.out.println(myBikes[i] instanceof Motorcycle); // another way to check
			
			for (int j = myBikes.length - 1; j > -1; j--) {
				// one way of checking a type
				System.out.println("Index: " + i + " " + myBikes[i].getClass());
				System.out.println("Index: " + j + " " + myBikes[j].getClass());
				
				// == for objects compares the memory location, which isnt always what we want
				// .equals is better
				// by default all of these look at memory locations
				if (myBikes[i].equals(myBikes[j])) {
					System.out.println("Same Bike");
				} else {
					System.out.println("Different Bike");
				}
				System.out.println();
			}
		}

		// can compare our object to null
		Motorcycle temp = null;
		System.out.println(myBikes[1].equals(temp));

		// cannot compare null to something
		
		// the order of a null object does matter,
		// you cannot call methods on something that is null
		System.out.println(temp.equals(myBikes[1]));
		
		// null is a valid value for non-primitives (objects), but it is
		// not a valid value for use as far as calling methods or doing
		// calculations
		
		// always do your null checks first
	}
	
	public void rideBike() {
		// abstract classes are just like interfaces
		// they cannot be directly instantiated
		//Vehicle myCar = new Vehicle();
		Vehicle myBike = new GrandTouring("Ducati", "Monster", "Red", 190, "Small", false);
		System.out.println(myBike);
		// only have access to Vehicle methods and properties because
		// the data type for myBike is Vehicle
		myBike.drive();
		myBike.park();
		myBike.honk();
		
		Vehicle myOtherBike = new GrandTouring("Harley Davidson", "Tri-Glide Ultra", 
				"Ultra Burnt Orange", 120, "Large", true);
		System.out.println(myOtherBike);
		myOtherBike.drive();
		myOtherBike.park();
		myOtherBike.honk();
		
		Motorcycle myThirdBike = new Sport("Triumph", "Daytona", "Blue", 194, "Medium", true);
		System.out.println(myThirdBike);
		// only have access to Motorcycle methods and properties because
		// the data type for myBike is Motorcycle
		myThirdBike.drive();
		myThirdBike.park();
		myThirdBike.honk();
		
	}
	
	public void sharkExhibit() {
		// cannot do this
		// cannot sue an interface to create and interface
		// interfaces are abstract
		//Shark mark = new Shark();
		try {
			System.out.println("****** Mark *******");
			//you need something that implements it
			// HammerHead is a shark, so it works
			Shark mark = new HammerHead("Mark", 18, 700, 20, 35);
			
			// I have access to any of the methods defined in my interface
			// every Shark will
			mark.bite();
			mark.swim(200);
			mark.hunt();
			
			System.out.println("****** Final Form Mark ******");
			// I do not have access to HammerHead specific things because 
			// mark's type is Shark, so mark is a reference to a Shark
			// it only gives you access to what it can gaurantee exists.
			// it can only guarantee Shark methods based on the information it's given
			HammerHead actualMark = (HammerHead)mark;
			
			actualMark.setName("True Mark");
			System.out.println(actualMark.getBiteForce());
			
			// actualMark and mark refer to the exact same object
			System.out.println(actualMark);
			System.out.println(mark);
			System.out.println(actualMark == mark);
			
			actualMark.bite();
			actualMark.swim(200);
			actualMark.hunt();
			mark.bite();
			mark.swim(200);
			mark.hunt();
			
			System.out.println("***** Eddy ******");
			Shark eddy = new Goblin("Eddy", 12, 10, 45);
			
			eddy.swim(9);
			eddy.bite();
			eddy.hunt();
	
			// the compiler does not pre-check casts, it runs it and finds out if it
			// works or not during runtime
			// this cast will fail when it runs because a HammerHead is not a Goblin
			// but both are sharks
			//Goblin actualEddy = (Goblin)mark;
			Goblin actualEddy = (Goblin)eddy;
			
			// because Java knows actualEddy is guaranteed to be a Goblin we have
			// access to Goblin specific methods
			actualEddy.setName("True Eddy");
			
			System.out.println("***** Jimbo ******");
			Shark jimbo = new BlackTip("Jimbo", 5, 63, 17);
			
			jimbo.swim(75);
			jimbo.bite();
			jimbo.hunt();
			
			BlackTip actualJimbo = (BlackTip)jimbo;
			
			actualJimbo.swim(75);
			actualJimbo.bite();
			actualJimbo.hunt();
			
			Shark[] sharkList = new Shark[3];
			// I do not need a cast to go from a child class to a parent class
			// I do need a cast to go from a parent class to a child class
			sharkList[0] = actualMark;
			sharkList[1] = actualEddy;
			sharkList[2] = actualJimbo;
			
			
			System.out.println("****** Shark Bait Hoo HaHa *******");
			// can use an interface to write my code once and have it work for 
			// every single Shark that will ever be made, as long as it uses Shark methods
			sharkBait(sharkList);
			
			// this works because a BlackTip shark is a fish
			Fish petFish = actualJimbo;
			// cannot do that with HammerHeads or Goblins because they do not implement
			// fish. 
			System.out.println(petFish == actualJimbo);
			System.out.println(actualJimbo == jimbo);
		} catch (ImATeapotException ex) {
			System.out.println("It's a teapot");
			ex.printStackTrace();
		} catch (CloneNotSupportedException ex) {
			ex.printStackTrace();
		}
	}
	
	private void sharkBait(Shark[] sharks) {
		for (int i = 0; i < sharks.length; i++) {
			try {
				sharks[i].swim(320);
				System.out.println("There's bait in the water. Hoo HaHa!");
				sharks[i].hunt();
			} catch (CloneNotSupportedException ex) {
				ex.printStackTrace(); // never going to run into this
			}
		}
	}
	
	public void birdExhibit() {
		Bird larry = new Bird("Larry", "Red", true, true, 88);
		
		larry.feed(20);
		larry.flap(15);
		larry.speak();
		larry.migrate();
		
		// through inheritance i have all the methods of bird
		// but i didnt have to retype them
		Ostrich steve = new Ostrich("Steve", "Brown", true, false, 45);
		//steve.setName("Steve");
		//steve.setColor("Brown");
		//steve.setTopSpeed(45);
		//steve.setCarnivore(true);
		//steve.setFly(false);
		
		// it sees these methods exist in the aprent class, and not the child
		// and instead uses theirs
		steve.feed(60.5);
		steve.flap(3);
		steve.speak();
		steve.migrate();
		// inheritance goes one way, parent -> child
		steve.hide(10); // this method is unique to ostriches
		
		Eagle tyrone = new Eagle("Tyrone", "Brown", true, true, 75);
		tyrone.feed(100);
		tyrone.flap(16);
		tyrone.speak();
		tyrone.migrate();
		
		Penguin micheal = new Penguin("Micheal", "White", true, false, 150);
		micheal.feed(53.2);
		micheal.flap(32);
		micheal.speak();
		micheal.dance();
		micheal.slide(20);
		micheal.migrate();
		
		// BaldEagle extends eagle, but eagle extends bird, so by extension a 
		// bald eagle is a bird
		// it is a grandchild of bird
		BaldEagle baldilocks = new BaldEagle();
		baldilocks.setName("Baldilocks");
		baldilocks.setColor("Blonde");
		baldilocks.setCarnivore(true);
		baldilocks.setFly(true);
		baldilocks.setTopSpeed(276);
		baldilocks.flap(40);
		baldilocks.feed(24.6);
		baldilocks.migrate();
		baldilocks.speak();
		
		// final variables cannot be changed
		//baldilocks.wingspan = "12 feet";
		
		EmperorPenguin ceasar = new EmperorPenguin("Ceasar", "Black", true, false, 282);
		//ceasar.setName("Ceasar");
		ceasar.dance(); // final on methods, does not stop inheritance
		
		// I can make an array of birds
		// covariance
		// through inheritance I can use a common parent class
		// to generalize methods
		Bird[] bords = new Bird[6];
		bords[0] = ceasar; // an emperor penguin is a bird
		bords[1] = baldilocks; // an bald eagle is a bird
		bords[2] = micheal; // an penguin is a bird
		bords[3] = larry; // an bird is a bird
		bords[4] = steve; // an ostrich is a bird
		bords[5] = tyrone; // an eagle is a bird
		
		viewBirds(bords);
	}
	
	private void viewBirds(Bird[] birds) {
		// can use any shared methods here, 
		// java will look atthe underlying type and use that method
		System.out.println("******* Bird Viewing ********");
		for (int i = 0; i < birds.length; i++) {
			System.out.println("******* " + birds[i].getName() + " ********");
			// system.out.println just calls an object's toString() method
			System.out.println(birds[i]);
			birds[i].feed(20);
			birds[i].flap(15);
			birds[i].speak();
			birds[i].migrate();
			
			if (birds[i] instanceof Penguin) {
				// both of the below do the same thing
				// casts the bird to a penguin and then uses a penguin specific method
				((Penguin)birds[i]).dance();
				((Penguin)birds[i]).slide(7);
//				Penguin temp = (Penguin)birds[i];
//				temp.dance();
			}
		}
	}
	
	// this method is an instance method, it exists on an instance of a Zoo
	public void sellPopcorn() {
		System.out.println("Popcorn! Get your popcorn here!");
		System.out.println("Dont feed the animals!");
	}
}
