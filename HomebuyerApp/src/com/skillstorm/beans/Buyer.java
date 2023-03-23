package com.skillstorm.beans;

public class Buyer {

	private String name;
	private String email;
	private String phoneNumber;
	private int numHomes;
	private Home[] homes;
	
	public Buyer(String name, String email, String phoneNumber) {
		// these are the only values im going to have my users tell me
		// the rest I want to default
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.numHomes = 0;
		this.homes = new Home[10];
	}
	
	// a buyer can also buy a home
	public void buyHome(Home newHome) {
		if (this.numHomes < homes.length) {
			// if numHomes = 5 and homes.length = 10 then i have plenty of space
			// numHomes is always going to be 1 more than the index of my latest home
			newHome.setOwner(this.name);
			homes[this.numHomes] = newHome;
		} else {
			// numHomes is not less than homes.length, i need a larger array
			Home[] temp = new Home[this.homes.length * 2]; // double my capacity
			
			for (int i = 0; i < this.homes.length; i++) {
				temp[i] = this.homes[i]; // manually copy the values over
			}

			newHome.setOwner(this.name);
			temp[this.numHomes] = newHome;
			this.homes = temp; // set homes equal to the new array
			
		}
		// im buying a house regardless of the path
		this.numHomes++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// this is a value im going to update, so i dont need a setter
	public int getNumHomes() {
		return this.numHomes;
	}
	
	// users can view their homes, but cannot delete them
	public Home[] getHomes() {
		return this.homes.clone();
		// dont want to give users the actuall array, want to give them a copy of it
		//return this.homes;
	}
	
	@Override
	public String toString() {
		return String.format("[Buyer: name = %s, email = %s, phone = %s, homes = %d]", 
				this.name, this.email, this.phoneNumber, this.numHomes);
	}
}
