package com.skillstorm.models;

// this class will have some functionality
public class Movie {

	private String title;
	private int year;
	private String rating;
	private int runtime;
	private String genre;
	private double score;
	
	public Movie() { }
	
	public Movie(String title, int year, String rating, int runtime, String genre, double score) {
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.runtime = runtime;
		this.genre = genre;
		this.score = score;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public int getRuntime() {
		return this.runtime;
	}
	
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	// check admission based on age
	public boolean checkAdmission(int age) {
		// R - 18+
		// PG-13 - 13+
		// PG - 7+
		// G - everyone
		// Not Rated - everyone
		// default - throw an exception
		switch(this.rating) {
			case "R": 
				// if age is 18 and up they can watch
				return age >= 18 ? true : false;
			case "PG-13":
				// if age is 13 and up they can watch
				return age >= 13 ? true : false;
			case "PG":
				// if age is 7 and up they can watch
				return age >= 7 ? true : false;
			case "G":
				// all are admitted
				return true;
			case "Not Rated":
				return true;
			default:
				throw new IllegalArgumentException("Invalid Rating: " + this.rating);
		}
	}
	
	// check if there is time to watch the movie
	public boolean isTime(int minutes) {
		return this.runtime <= minutes;
	}
	
	// compare genre
	public boolean isGenre(String genre) {
		return this.genre.toLowerCase().contains(genre.toLowerCase());
	}
	
	// compare review scores
	public boolean compareReviews(Movie other) {
		return this.score > other.getScore();
	}
}
