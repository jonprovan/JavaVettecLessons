package com.skillstorm.threadedsum;

public class Main {

	public static void main(String[] args) {
		ThreadedSum even = new ThreadedSum(0, 10);
		ThreadedSum odd = new ThreadedSum(1, 10);
		
		even.start();
		odd.start();
		
		try {
			even.join();
			odd.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println(even.getSum() + odd.getSum());
	}
}
