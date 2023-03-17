package com.skillstorm.beans;

// I can implement as many interfaces as I want
public class BlackTip implements Shark, Fish {

	private String name;
	private double length;
	private double speed;
	private int humanAttacks;
	
	public BlackTip(String name, double length, double speed, int attacks) {
		this.name = name;
		this.length = length;
		this.speed = speed;
		this.humanAttacks = attacks;
	}
	
	@Override
	public void swim(double distance) {
		System.out.println(name + " swims " + distance + " miles looking for humans at " 
					+ speed + " mph.");
	}

	@Override
	public void bite() {
		System.out.println(name + " finds a human! and bites with " + 
					(length * humanAttacks) + " N.");	
		this.humanAttacks++;
	}

	@Override
	public void hunt() {
		System.out.println("Fish are friends, not food!");
		swim(length * humanAttacks + speed);
		bite();
		System.out.println(name + " swims off to the beach. Satisfied");
	}

	@Override
	public void bubbles() {
		System.out.println("Glub Glub");
	}

	@Override
	public void view() {
		System.out.println("My name is " + name + " I am a " + 
				length + " ft long Black Tip Shark. I have bit " + humanAttacks 
				+ " people....that you know of...."); 
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public int getHumanAttacks() {
		return this.humanAttacks;
	}
	
	public void setHumanAttacks(int attacks) {
		this.humanAttacks = attacks;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
