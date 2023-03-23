package com.skillstorm;

import java.util.Scanner;

import com.skillstorm.beans.Buyer;
import com.skillstorm.services.HousingService;
import com.skillstorm.services.UserService;

public class Homebuyer {
	
	// this is the main that will run everything for my app
	// this is an app where a user can come and buy a house
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); // need a scanner to pass around
		
		// my service is going to have all my user functionality
		// i can use it to get a user and pass it elsewhere
		UserService uService = new UserService();
		HousingService hService = new HousingService();
		Buyer customer = uService.welcome(in);
		
		if (customer != null) {
			hService.displayHousing(customer, in);
			System.out.println("Congratulations " + customer.getName() + "!");
			System.out.println(customer);
		} else {
			System.out.println("Goodbye");
		}
		
		in.close();
	}
}
