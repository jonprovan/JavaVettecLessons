package com.skillstorm.services;

import java.util.Scanner;

import com.skillstorm.beans.Buyer;
import com.skillstorm.beans.Home;

// everything home related
public class HousingService {

	private Home[] florida;
	private Home[] texas;
	private Home[] newJersey;
	
	public HousingService() {
		setup();
	}
	
	public void displayHousing(Buyer user, Scanner in) {
		System.out.println("Thank you for using our service");
		
		boolean cont = false;
		int choice = 0;
		do {
			System.out.println("What state would you like to purchase a house in?");
			System.out.println("1. Florida \n2. Texas \n3. New Jersey");
			choice = Integer.parseInt(in.nextLine().trim());
			
			if (choice < 1 || choice > 3) {
				System.out.println("Sorry, we dont offer houses in that state");
				cont = true;
			} else {
				cont = false;
			}
		} while (cont);
		
		Home purchasedHome = null;
		if (choice == 1) {
			// they're a florida man
			purchasedHome = displayAvailable(florida, in);
		} else if (choice == 2) {
			// they're from texas
			purchasedHome = displayAvailable(texas, in);
		} else {
			// they're from the shore
			purchasedHome = displayAvailable(newJersey, in);
		}
		
		// finally I have a house
		user.buyHome(purchasedHome);
	}
	
	private Home displayAvailable(Home[] homes, Scanner in) {
		//TODO: Add logic for if all the houses in a state are already taken
		
		// this will display the available houses in a state, and do the purchase for that user
		boolean cont = false;
		int choice = 0;
		do {
			System.out.println("Here are our available houses");
			System.out.println("Which would you like to purchase?");
			for (int i = 0; i < homes.length; i++) {
				if (homes[i].getOwner().equals("N/A")) {
					System.out.println(i + ". " + homes[i]);
				}
			}
			
			choice = Integer.parseInt(in.nextLine().trim());
			
			if (choice < 0 || choice > 4) {
				System.out.println("Please choose an available house");
				cont = true;
			} else if (!homes[choice].getOwner().equals("N/A")) {
				System.out.println("That house already has an owner");
				System.out.println("Please choose an available house");
				cont = true;
			} else {
				cont = false;
			}
		} while(cont);
		
		return homes[choice];
	}
	
	// just test data to be able to display something
	private void setup() {
		// to keep my setup code away from everything else
		florida = new Home[5];
		texas = new Home[5];
		newJersey = new Home[5];
		
		florida[0] = new Home("124 traveler lane", "Florida", 342321.99);
		florida[1] = new Home("134 traveler lane", "Florida", 312331.99);
		florida[2] = new Home("4321 mocking bird lane", "Florida", 422321.99);
		florida[3] = new Home("4322 mocking bird lane", "Florida", 142321.99);
		florida[4] = new Home("778 tower way", "Florida", 242321.99);
		
		texas[0] = new Home("124 taco lane", "Texas", 342321.99);
		texas[1] = new Home("134 taco lane", "Texas", 312331.99);
		texas[2] = new Home("4321 blues alley", "Texas", 422321.99);
		texas[3] = new Home("4322 blues alley", "Texas", 142321.99);
		texas[4] = new Home("778 hollyhock street", "Texas", 242321.99);
		
		newJersey[0] = new Home("124 flower street", "New Jersey", 342321.99);
		newJersey[1] = new Home("134 flower street", "New Jersey", 312331.99);
		newJersey[2] = new Home("4321 encanto boulevard", "New Jersey", 422321.99);
		newJersey[3] = new Home("4322 encanto boulevard", "New Jersey", 142321.99);
		newJersey[4] = new Home("778 thomas road", "New Jersey", 242321.99);
	}
}
