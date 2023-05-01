package com.skillstorm.threadedsum;

public class ThreadedSum extends Thread {

	private int sum = 0;
	private int start;
	private int end;
	
	public ThreadedSum(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int getSum() {
		return this.sum;
	}
	
	@Override
	public void run() {
		/* even thread:
		 * start = 0;
		 * end = 10;
		 * sum = 0;
		 * 
		 * sum += 0
		 * sum += 2
		 * sum += 4
		 * sum += 6
		 * sum += 8
		 * sum += 10
		 * 
		 * odd thread:
		 * start = 1;
		 * end = 10;
		 * sum = 0;
		 * 
		 * sum += 1
		 * sum += 3
		 * sum += 5
		 * sum += 7
		 * sum += 9
		 */
		for (int i = start; i <= end; i+=2) {
			sum += i;
		}
	}
}
