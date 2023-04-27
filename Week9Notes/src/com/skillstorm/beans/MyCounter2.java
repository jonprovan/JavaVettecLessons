package com.skillstorm.beans;

public class MyCounter2 implements Runnable {
	// can implement runnable to also create something that can be run in a thread
	private int count;
	
	public MyCounter2(int count) {
		this.count = count;
	}

	// if I just directly call the run method it will run in the current thread
	// not a new one
	@Override
	public void run() {
		// printing out ever even number
		for (int i = 0; i < count; i+=2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
}
