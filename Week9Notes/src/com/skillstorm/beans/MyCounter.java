package com.skillstorm.beans;

public class MyCounter extends Thread {

	private int count;
	
	public MyCounter(int count) {
		this.count = count;
	}
	
	// I can put the code for running a thread inside it's own class
	@Override
	public void run() {
		for (int i = 0; i < count; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
