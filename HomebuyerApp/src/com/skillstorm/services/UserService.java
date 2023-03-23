package com.skillstorm.services;

import java.util.Scanner;

import com.skillstorm.beans.Buyer;

// everything user experience, mostly dealing with buyer accounts
public class UserService {
	
	// for the setup i have no one really needs to access any of this
	private Buyer[] users;
	private int numUsers;

	public UserService() {
		// im choosing what we start with
		this.users = new Buyer[5];
		this.users[0] = new Buyer("Dan Pickles", "dantheman97@gmail.com", "3324726352");
		this.users[1] = new Buyer("Bruce Wayne", "Vengeance@gmail.com", "3333333333");
		this.numUsers = 2;
	}
	
	public Buyer welcome(Scanner in) {
		System.out.println("Welcome to the HomeBuyer App!!!\n");
		
		boolean cont = false; // just a flag
		int choice; // need this scoped outside of my while loop so i can use it later
		do {
			System.out.println("Are you: ");
			System.out.println("1. A new user?");
			System.out.println("2. A returning user?");
			choice = Integer.parseInt(in.nextLine().trim());
			
			// make sure my continue flag is properly set
			if (choice < 1 || choice > 2) {
				System.out.println("Please enter a 1 or a 2");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		if (choice == 1) {
			// new user
			System.out.println("There are no new users");
			return null; // objects can be null
		} else {
			// returning user
			return existingUser(in);
		}
	}
	
	// this method will grab an existing user and return that
	public Buyer existingUser(Scanner in) {
		System.out.println("Ok....");
		
		boolean cont = false;
		Buyer user = null;
		do {
			System.out.println("Who are you?");
			for (int i = 0; i < numUsers; i++) {
				System.out.println(i + ". " + users[i]);
			}
			int choice = Integer.parseInt(in.nextLine().trim());
			
			if (choice < 0 || choice > numUsers - 1) {
				System.out.println("Please select a user");
				cont = true;
			} else {
				user = users[choice];
				System.out.println("Welcome back " + user.getName());
				cont = false;
			}
		} while(cont);
		
		return user;
	}
}
