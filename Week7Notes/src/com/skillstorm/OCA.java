package com.skillstorm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.skillstorm.beans.Sedan;

public class OCA {

	public static void main(String[] args) {
		multiDimensionalLists();
	}
	
	public static void multiDimensionalLists() {
		// same way that we can have an array inside an array....
		// we can have a List inside a list....
		// same goes for other data structures
		
		// this task is better suited to multidimensional arrays, not Lists
		ArrayList<ArrayList<Integer>> myNums = new ArrayList<ArrayList<Integer>>();
		//System.out.println(myNums.get(9));
		myNums.add(new ArrayList<Integer>());
		myNums.get(0).add(4); // added for to index 0,0
		System.out.println(myNums);
		
		// this is what you want to use
		// I can see that this is a 10 x 10 array
		// i can see that, that wont change easily
		int[][] myNums2 = new int[10][10];
		System.out.println(myNums2[9]);
		myNums2[0][0] = 4;
		
		// where I would want to use an List over an array
		// nissanInvenotory essentially makes named buckets, in those buckets I throw 
		// cars that I have on me
		Map<String, ArrayList<Sedan>> nissanInventory = new HashMap<>();
		nissanInventory.put("Altima", new ArrayList<Sedan>()); // not I have a spot to put altimas
		nissanInventory.put("Maxima", new ArrayList<Sedan>());
		
		System.out.println(nissanInventory);
		
		Sedan altima1 = new Sedan();
		Sedan altima2 = new Sedan("Red", "Nissan", "Altima");
		Sedan maxima1 = new Sedan("White", "Nissan", "Maxima");
		
		// get my list of x Sedans and add in the new Sedan
//		nissanInventory.get("Altima").add(altima1);
//		nissanInventory.get("Altima").add(altima2);
//		nissanInventory.get("Maxima").add(maxima1);
		
		// what i did above
		ArrayList<Sedan> altimas = nissanInventory.get("Altima");
		altimas.add(altima1);
		altimas.add(altima2);
		
		ArrayList<Sedan> maximas = nissanInventory.get("Maxima");
		maximas.add(maxima1);
		
		// lists are better for things that change in size often, arrays are better for things
		// that do not change in size often
		System.out.println(nissanInventory);
		
		// can use the above to adjust the inventory as needed
		altimas.remove(altima2);
		
		System.out.println(nissanInventory);
		
		// to add in a new list of cars, for a new type of vehicle
		ArrayList<Sedan> sentras = new ArrayList<>();
		sentras.add(new Sedan("Orange", "Nissan", "Sentra"));
		sentras.add(new Sedan("Orange", "Nissan", "Sentra"));
		sentras.add(new Sedan("Green", "Nissan", "Sentra"));
		sentras.add(new Sedan("White", "Nissan", "Sentra"));
		
		// and again adjust the inventory
		nissanInventory.put("Sentra", sentras);
		nissanInventory.get("Altima").add(new Sedan("Red", "Nissan", "Altima"));
		nissanInventory.get("Altima").add(new Sedan("Red", "Nissan", "Altima"));
		
		System.out.println(nissanInventory);
		
		// I want to update the model to be "Altima v2"
		System.out.println(nissanInventory.get("Altima"));
		
		for (Sedan nissan : nissanInventory.get("Altima")) {
			String name = nissan.getModel();
			name += " v2";
			
			nissan.setModel(name);
		}
		
		System.out.println(nissanInventory.get("Altima"));
	}
}
