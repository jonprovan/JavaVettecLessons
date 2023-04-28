package com.skillstorm.beans;

public class LongRunningThread extends Thread {

	private int value;
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public void run() {
		// infinite loop
		while (true) {
			value++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException ex) {
				System.out.println(this.getName() + ": I got interrupted");
			}
		}
	}
}
