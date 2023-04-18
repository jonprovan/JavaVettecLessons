package com.skillstorm.beans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
// all of this comes from java.io (java.input/output)
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileReader {

	// this is our class that will read from a file
	// when reading from a file, you need to know where that file is
	
	// two types of file paths
	// you have a relative path - is not the full path, is relative to where you are in your
	// 		file system at the time
	// you have an full/ absolute path - your full address from your C drive all the way to the 
	// 	 	file. Absolute paths always work no matter where you are in your file system
	private final String txtFile = "C:\\Skillstorm\\JavaVettecLessons\\Week8Notes\\src\\MyAwesomeFile.txt";
	private final String txtFile2 = "C:\\Skillstorm\\JavaVettecLessons\\Week8Notes\\src\\MyAwesomeFile2.txt";
	
	public void readFile() {
		// what I want to do is just read the file and display the text to the user
		FileInputStream in = null; // this is uised to read files
		
		try {
			in = new FileInputStream(txtFile); // throws an exception if the file doesnt exist
			
			int inByte; // is going to be used in reading in the file
			// FileInputStreams read in your data 1 byte at a time and when 
			// we hit the end of our file it returns -1. -1 represent eof (end of)
			System.out.println("My Awesome File: ");
			while ((inByte = in.read()) != -1) {
				// read in a byte, assign it to inBtye, and if it isnt -1 (eof) then print it
				System.out.print((char)inByte); // need to convert into letters
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) { // has to come last because a FileNotFound is an IOException
			ex.printStackTrace();
		} finally {
			// but closing it also throws an exception
			try {
				in.close(); // I need to close this file regardless of what happens in the code
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void readFile2() {
		// the same as above, but better
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(txtFile); // still throws a file not found
			br = new BufferedReader(fr); // buffered reader does the actual reading
			// takes in a file reader
			String line;
			
			System.out.println("My Awesome File: ");
			// buffered reader returns null when it hits eof
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					System.out.println(line.trim());
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			// still need to close these once we open them
			try {
				br.close();
				fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void readFile3() {
		// I can tell Java I want it to handle the closing my file for me
		// in Java they give us access to a special try-catch that manages the resources for us
		
		// try with resources block
		// only works with Disposable resources
		// Disposable is an interface that tells Java how to dispose of something
		// can define multiple resourced seperated by semi-colons
//		try (FileReader fr = new FileReader(txtFile); 
//				BufferedReader br = new BufferedReader(fr)) {
		try(BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
			// can define multiple things in my resources part of the try with resources
			// it disposes of them in reverse order of when they were declared
			// disposes of them regardless of the outcome of the program
			System.out.println("My Awesome File: ");
			String line;
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty()) {
					System.out.println(line.trim());
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void writeFile() {
		// now I want to write to a file
		File file = new File(txtFile2);
		// File is an object, objects can be null. Your files can be null
		
		// check if file exists
		if (file.exists()) {
			System.out.println("The file is real!");
		} else {
			System.out.println("No idea what that is");
		}
		
		if (file.isDirectory()) {
			System.out.println("It's a directory!");
		} else {
			System.out.println("It's not a directory");
		}
		
		// BufferedReader and FileReader read from the file
		// BufferedWriter and FileWriter write to the file
		
		// BufferedWriter creates the file if it doesnt exist, and overwrites it if it does
		// by default it overwrites, but if i set append to be true, then it doesnt
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(txtFile2, true))) {
			// if the file does not xist, this creates it and writes to it
			bw.write("My New Text for my new file\n");
			bw.newLine();
			bw.write("Some more text for good measure");
			bw.newLine();
			bw.write("***********");
			bw.newLine();
			// append and write methods do the exact same thing
//			bw.append("New Text");
//			bw.append("Even more new text");
//			bw.append("Even more newer text");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// what if i want to read from excel/ any CSV
	// what if i want to create a CSV?
}
