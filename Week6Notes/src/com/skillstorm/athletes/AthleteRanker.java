package com.skillstorm.athletes;

import java.util.ArrayList;
import java.util.Collections;

public class AthleteRanker {

	public static void main(String[] args) {
		// this is going to handle ranking my athletes
		
		// test what I have so far
//		Athlete test = new Athlete("Dan Pickles", 12, 1);
//		
//		System.out.println(test);
		
		ArrayList<Athlete> athletes = new ArrayList<>();
		athletes.add(new Athlete("Dan Pickles", 11, 3));
		athletes.add(new Athlete("Jon Provan", 15, 15));
		athletes.add(new Athlete("Miles Mixon", 45, 4));
		athletes.add(new Athlete("Erica Hicks", 17, 6));
		athletes.add(new Athlete("Patrick Walsh", 90, 0));
		System.out.println(athletes); // before the sort
		
		Collections.sort(athletes);
		System.out.println(athletes); // after the sort
	}
}
