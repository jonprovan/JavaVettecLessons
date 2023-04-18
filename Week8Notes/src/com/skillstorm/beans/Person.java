package com.skillstorm.beans;

// this class represents the data from my CSV file
public class Person {
	private String name;
	private int age;
	private String hairColor;
	
	public Person(String name, int age, String hairColor) {
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getHairColor() {
		return this.hairColor;
	}
	
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	
	@Override
	public String toString() {
		return "[ Name = " + name + ", Age = " + age + ", Hair Color = " + hairColor + " ]";
	}
}
