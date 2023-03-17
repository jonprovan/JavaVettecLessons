package com.skillstorm.beans;

public class Goblin implements Shark {

	private String name;
	private double noseLength;
	private int howScary;
	private double speed;
	
	public Goblin(String name, double noseLength, int howScary, double speed) {
		this.name = name;
		this.noseLength = noseLength;
		this.howScary = howScary;
		this.speed = speed;
	}
	
	@Override
	public void swim(double distance) {
		System.out.println(name + " swims " + (distance * noseLength) + 
				" miles at " + speed + " mph.");
	}

	@Override
	public void bite() {
		System.out.println(name + " bites? With the force of " + (howScary * noseLength) + " N.");
		
		if (howScary < 5) {
			System.out.println("It was adorable!");
		} else {
			System.out.println("EEEKKK!");
		}
	}

	@Override
	public void hunt() {
		swim(howScary * noseLength);
		bite();
		System.out.println(name + " swims off into the deep at " + speed + " mph. Satisfied");
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getNoseLength() {
		return this.noseLength;
	}
	
	public void setNoseLength(double noseLength) {
		this.noseLength = noseLength;
	}
	
	public int getHowScary() {
		return this.howScary;
	}
	
	public void setHowScary(int scary) {
		this.howScary = scary;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
