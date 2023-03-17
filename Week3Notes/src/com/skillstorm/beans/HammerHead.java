package com.skillstorm.beans;

import java.util.ArrayList;
import java.util.List;

// interfaces use the implements keyword
public class HammerHead implements Shark {
	
	private String name;
	private double length;
	private double biteForce;
	private double headSize;
	private double speed;
	
	public HammerHead(String name, double length, double biteForce, 
					  double headSize, double speed) {
		this.name = name;
		this.length = length;
		this.biteForce = biteForce;
		this.headSize = headSize;
		this.speed = speed;
	}
	
	// i need to implement these 3 methods that are in my interface
	// or my class will not compile
	@Override
	public void swim(double distance) {
		System.out.println(name + " is swimming " + ((distance/headSize) * biteForce) 
							+ " miles at " + speed + " mph.");
	}

	@Override
	public void bite() {
		System.out.println(name + " bit with the strength of " + biteForce + " N.");
	}

	@Override
	public void hunt() {
		swim((length/headSize) * speed);
		bite();
		System.out.println(name + " swims off into the sunset, satisfied.");
	}

	// still need to properly encapsulate
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
	
	public double getBiteForce() {
		return this.biteForce;
	}
	
	public void setBiteForce(double force) {
		this.biteForce = force;
	}
	
	public double getHeadSize() {
		return this.headSize;
	}
	
	public void setHeadSize(double headSize) {
		this.headSize = headSize;
	}
	
	public double getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
