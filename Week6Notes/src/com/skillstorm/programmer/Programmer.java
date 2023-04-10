package com.skillstorm.programmer;

import java.util.ArrayList;

public class Programmer {

	private String name;
	private String company;
	private ArrayList<String> languages;
	
	public Programmer(String name, String company) {
		this.name = name;
		this.company = company;
		this.languages = new ArrayList<>();
	}
	
// for testing purposes
//	public void printList() {
//		System.out.println(this.languages);
//	}
	
	public void learnLanguage(String language) {
		if (language != null && !language.trim().equals("") && !this.languages.contains(language)) {
			this.languages.add(language);
		}
	}
	
	public void forgetLanguage(String language) {
		if (language != null && !language.trim().equals("")) {
			this.languages.remove(language);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	// no setter because I want them to go through my methods
	public ArrayList<String> getLanguages() {
		// languages are an arraylist, that means this is an object
		// so we want to return a clone/copy of it
		return new ArrayList<String>(this.languages);
	}
	
	@Override
	public String toString() {
		return "[ " + this.name + ", " + this.company + ", languages: " + this.languages + "]";
	}
}
