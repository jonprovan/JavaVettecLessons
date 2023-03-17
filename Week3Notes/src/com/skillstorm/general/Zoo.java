package com.skillstorm.general;

import com.skillstorm.beans.BaldEagle;
import com.skillstorm.beans.Bird;
import com.skillstorm.beans.BlackTip;
import com.skillstorm.beans.Eagle;
import com.skillstorm.beans.EmperorPenguin;
import com.skillstorm.beans.Fish;
import com.skillstorm.beans.Goblin;
import com.skillstorm.beans.HammerHead;
import com.skillstorm.beans.Ostrich;
import com.skillstorm.beans.Penguin;
import com.skillstorm.beans.Shark;

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
		phillyZoo.sharkExhibit();
	}
	
	public static void buyTickets(int num) {
		double amount = num * (TICKETPRICE * 1.06);
		
		// format is a static method of the String class
		// static methods are called with the class name, not the instance
		System.out.println(String.format("That will be $%.2f", amount));
	}
	
	public void sharkExhibit() {
		// cannot do this
		// cannot sue an interface to create and interface
		// interfaces are abstract
		//Shark mark = new Shark();
		
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
		// cannot do that with HammerHeads or Goblin sbecause they do not implement
		// fish. 
		System.out.println(petFish == actualJimbo);
		System.out.println(actualJimbo == jimbo);
	}
	
	private void sharkBait(Shark[] sharks) {
		for (int i = 0; i < sharks.length; i++) {
			sharks[i].swim(320);
			System.out.println("There's bait in the water. Hoo HaHa!");
			sharks[i].hunt();
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
