package com.skillstorm.beans;

public class Home {

	private String address;
	private double price;
	private String owner;
	private String state; // ex/ MD, CA, PA...
	
	public Home(String address, String state, double price) {
		this.address = address;
		this.state = state;
		this.price = price;
		this.owner = "N/A";
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	// homes wont be able to change what state they're in
	public String getState() {
		return this.state;
	}
	
	@Override
	public String toString() {
		return String.format("[Home: address = %s, state = %s, price = %f, owner = %s]", 
				this.address, this.state, this.price, this.owner);
	}
}
