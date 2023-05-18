package com.skillstorm;

import java.util.ArrayList;

import com.skillstorm.models.Movie;

// all of your packages and source code for a Maven project go inside of src/main/java
// all of your test classes/ packages go inside of src/test/java
public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> test = new ArrayList<>();
		
		Movie actionMovie = new Movie("47 Ronin", 2013, "PG-13", 118, "Action", 6.2);
		
		System.out.println(actionMovie.checkAdmission(21));
		System.out.println(actionMovie.checkAdmission(7));
		System.out.println(actionMovie.checkAdmission(8));
	}
}
