package com.skillstorm.general2;

// need to import classes from other packages
import com.skillstorm.general.Animal;

public class TemporaryZoo {

	public static void main(String[] args) {
		Animal otherAnimal = new Animal("Ned", 42.3, false);
		
		// can set this because it is public
		otherAnimal.name = "Stan";
		
		// cannot access color here because it is default and this is a 
		// different package
		//otherAnimal.color = "Green";
		
		otherAnimal.setColor("Green");
		System.out.println(otherAnimal.getColor());
		
		// cannot access age here because it is protected and this is a
		// different package
		//otherAnimal.age = 62;
		
		// through public getters and setters I can access this
		otherAnimal.setAge(62);
		System.out.println(otherAnimal.getAge());
		
		// cannot access fur here because it is private and I am not inside
		// the animal class
		//otherAnimal.fur = true;
		
		otherAnimal.setFur(false);
		System.out.println(otherAnimal.hasFur());
	}
}
