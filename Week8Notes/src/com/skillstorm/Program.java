package com.skillstorm;

import java.util.List;

import com.skillstorm.beans.MyFileReader;
import com.skillstorm.beans.Person;

public class Program {

	public static void main(String[] args) {
		MyFileReader reader = new MyFileReader();
		
		//reader.readFile();
		//reader.readFile2();
		//reader.readFile3();
		//reader.writeFile();
		List<Person> people = reader.readCSV();
		
		System.out.println(people);
		//reader.writeCSV(people, "csvFile2.csv"); // relative path. places this file under whatever 
		// folder the app is running from
	}
}
