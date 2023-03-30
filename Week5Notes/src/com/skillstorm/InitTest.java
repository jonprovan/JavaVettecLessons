package com.skillstorm;

public class InitTest {

	static int si = 10;
	int i;
	final boolean bool;
	
	// really bad code, but valid in Java
	// block like this run whenever an instance is created
	{ 
		i = 1000; 
		System.out.println("Bad code! " + i);
	}
	
	// really bad code, but valid in Java
	static {
		si = 4;
		System.out.println("Static bad code! " + si);
	}
	
	InitTest() {
		bool = false;
	}
	
	InitTest(int val) {
		i = val;
		bool = true;
	}
}
