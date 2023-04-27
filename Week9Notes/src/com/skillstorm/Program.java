package com.skillstorm;

import com.skillstorm.beans.MyCounter;
import com.skillstorm.beans.MyCounter2;
import com.skillstorm.beans.NumHolder;

public class Program {

	// effectively takes this variable and places it on the heap
	// doesnt help with thread safety
	volatile static int y = 0;
	
	public static void main(String[] args) {
		//factorialAssignment();
		threads();
		
		System.out.println("Main method finished");
	}
	
	public static void threads() {
		// threads exist to do some job
		// they do some job as a background process
		// every thread needs an implementation of the run method
		Thread t1 = new Thread(() -> System.out.println("This is a thread 1"));
		Thread t2 = new Thread(() -> System.out.println("This is a thread 2"));
		
		// threads run separately from the main thread, the main thread does not wait
		// for threads to finish before it continues running
		
		// threads dont run/ are not fully created until you call start
		// start calls the run method of a runnable
		t1.start();
		t2.start();
		
		// the order i call start in is not the order they run in
		// the order of execution is never gauranteed
		try {
			// the join method tells the main thread to wait until these
			// finish running before continuing
			t1.join();
			t2.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		// The parent class of Thread is an interface called Runnable
		// can hand a thread a runnable
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Threads through a runnable 1");
			}
		});
		
		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Threads through a runnable 2");
			}
		});
		
		t3.start();
		t4.start();
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		MyCounter tCounter1 = new MyCounter(20);
		MyCounter tCounter2 = new MyCounter(15);
		MyCounter tCounter3 = new MyCounter(30);
		
		tCounter1.start();
		tCounter2.start();
		tCounter3.start();
		
		try {
			tCounter1.join();
			tCounter2.join();
			tCounter3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		// cant remember what number i left off at so we jumped to 6
		Thread t6 = new Thread(new MyCounter2(30));
		Thread t7 = new Thread(new MyCounter2(24));
		Thread t8 = new Thread(new MyCounter2(14));
		
		System.out.println();
		t6.start();
		t7.start();
		t8.start();
		
		try {
			t6.join();
			t7.join();
			t8.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		/*
		 * Thread States:
		 * 	new : thread was created
		 * 	runnable : thread is currently running or ready to run
		 * 	waiting : the thread has been told to wait on some condition. Releases any locks
		 * 	timed waiting : the thread has been told to wait for an amount of time. Does not 
		 * 					release any locks
		 *  terminated : the thread finished executing or crashed
		 *  blocked : the thread tried to access some resource and has to wait
		 */
		
		// Thread Safety
		// Local variables in threads are thread safe
		// Objects, and anything that exists before the thread is not
		// thread safe
		// there are thread safe implementations of certain objects
		
		// reading doesnt change values, so its thread safe, anytime you
		// change a value is when you have to consider thread safety
		NumHolder num = new NumHolder();
		num.x = 0;
		
		Thread th1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(i * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				num.x = num.x + 1;
			}
		});
		
		Thread th2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(i * 100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				num.x = num.x + 1;
			}
		});
		
		th1.start();
		th2.start();
		
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("X: " + num.x);
		
		// objects are on the heap, threads can access the heap at any time
		// but what if i dont want to wrap my primitives in an object
		// if i want to update the value in some way
		
		
		Thread th3 = new Thread(() -> {
			for(int i = 0; i< 10; i++) {
				y++;
			}
		});
		
		Thread th4 = new Thread(() -> {
			for(int i = 0; i< 10; i++) {
				y++;
			}
		});
		
		Thread th5 = new Thread(() -> {
			for(int i = 0; i< 10; i++) {
				y++;
			}
		});
		
		th3.start();
		th4.start();
		th5.start();
		
		try {
			th3.join();
			th4.join();
			th5.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Y: " + y);
	}
	
	public static void factorialAssignment() {
		System.out.println(factorial(3)); // should be 6
		System.out.println(factorial(6)); // should be 720
		System.out.println(factorial(10)); // should be 3,628,800
		System.out.println(factorial(0)); // should return 1
		System.out.println(factorial(1)); // should return 1
		
		try {
			System.out.println(factorial(-20)); // should return 1
		} catch (IllegalArgumentException ex) {
			System.out.println("Failed successfully");
		}
	}
	
	// Calculating Factorials
	public static long factorial(int n) {
		// if n is negative
		// if n is 0 (our base case)
		// else multiply
		if (n < 0) {
			throw new IllegalArgumentException();
		} else if (n == 0) {
			return 1;
		} else {
			return (long)n * factorial(n-1); 
		}
	}
}
