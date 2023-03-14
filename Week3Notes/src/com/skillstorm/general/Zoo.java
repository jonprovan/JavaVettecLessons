package com.skillstorm.general;

public class Zoo {

	// properties create a HAS-A relationship
	// a Zoo HAS-A name
	// a Zoo HAS-A address
	// a Zoo HAS-A master zoologist
	
	// this is a static variable
	public static String masterZoologist = "Anthony";
	
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
	}
	
	public static void buyTickets(int num) {
		double amount = num * (74.99 * 1.06);
		
		// format is a static method of the String class
		// static methods are called with the class name, not the instance
		System.out.println(String.format("That will be $%.2f", amount));
	}
	
	// this method is an instance method, it exists on an instance of a Zoo
	public void sellPopcorn() {
		System.out.println("Popcorn! Get your popcorn here!");
		System.out.println("Dont feed the animals!");
	}
}
