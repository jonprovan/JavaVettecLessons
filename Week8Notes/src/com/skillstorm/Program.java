package com.skillstorm;

import java.util.List;

import com.skillstorm.beans.MyFileReader;
import com.skillstorm.beans.Person;

class Super {
	static String ID = "QBANK";
}

class Sub extends Super {
	static int testNum = 5;
	
	static {
		System.out.println("In sub");
	}
	
	class SubSub {
		
	}
}

public class Program {
	
	static int[] x = new int[0];
	
	// static initializer blocks that throw an exception wrap it in an 
	// ExceptionInInitializerError, but in a non static block it throws the actual
	// exception
//	static {
//		x[0] = 10;
//	}
	
	public static void main(String[] args) {
		//Program test = new Program();
		//Sub.SubSub test = new Sub().new SubSub();
		//fileIO();		
		//testStuff();
		//threading();
		
		//System.out.println("Program is done");
		
		int i = 0; 
		
		i++; // 1
		System.out.println(i); // prints 1
		System.out.println(i++); // prints 1
		System.out.println(i); // prints 2
		
		++i; // 3
		System.out.println(i); // prints 3
		System.out.println(++i); // prints 4
		System.out.println(i); // prints 4
	}
	
	public static void threading() {
		// so far everything has been run in the main thread, every branches from
		// the main thread
		
		// multi-threading, is different
		// instead of having one thing run all of your code, you have multiple things 
		// running your code. depending on how it's written it can be very fast
		// too many threads and you slow your code down again
		
		// you dont control how a thread runs, you scheduler does
		
		// if i want to make a thread:
		// creating it is easy, but when you create you need to give it a job
		// Threads are Runnables, they implement the Runnable interface
		Thread t1 = new Thread(() -> { // Thread-0
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				//System.out.println("I'm a thread!");
			}
		});
		Thread t2 = new Thread(() -> { // Thread-1
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				//System.out.println("I'm a thread!");
			}
		});
		Thread t3 = new Thread(() -> { // Thread-2
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				//System.out.println("I'm a thread!");
			}
		});
		
		// they dont do anything until you give them a job, and actually tell them to
		// do that job 
		// you need to call this method or nothing happens
		t1.start();
		t2.start();
		t3.start();
		
		// threads take up memory, they all have their own individual call stack
		// threads dont stop taking up memory even after they finish their job, 
		// if they ever finish it
		
		// and the main thread does not wait for your threads before continuing
		try {
			// join tells your main thread to wait for these to die before continuing
			// also takes back the memory for you
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		Thread t4 = new Thread(new Runnable() {
			// can make a thread with anything that implements Runnable
			// Runnable is a functional interface, with the run method
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
				}
			}
		});
		Thread t5 = new Thread(new Runnable() {
			// can make a thread with anything that implements Runnable
			// Runnable is a functional interface, with the run method
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(Thread.currentThread().getName() + ": " + i);
				}
			}
		});
		
		System.out.println("\nRunnables vs lambdas: \n");
		t4.start();
		t5.start();
		
		try {
			t4.join();
			t5.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		/*
		 * Thread States:
		 * 	new: thread was created
		 * 	runnable: thread is either running, or ready to run
		 * 	waiting: anytime you tell a thread to wait. this state releases any locks
		 * 	timed waiting: anytime you tell a thread to wait for an amount of time. 
		 * 				   in this state locks are not released
		 * 	terminated: the thread is finished or the program crashed
		 * 	blocked: it tried to access a resource but has to wait
		 */
		
		// will still throw an exception, but will not crash my code
		// cant catch the exception outside the thread, need to catch it inside the 
		// thread. The exception never makes it out of the thread
		
		// you can name your threads, by giving it a name in the constructor
		Thread t6 = new Thread(() -> { throw new RuntimeException(); }, "Carl");
		
		try {
			t6.start();
		} catch (Exception ex) {
			System.out.println("Exception caught");
		}
		
		try {
			t6.join();
		} catch (InterruptedException ex) {
			System.out.println("Thread interrupted!");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Caught an exception");
		}
		
		// an exception in the main thread kills your program, because your program runs
		// in the main thread
		//throw new RuntimeException();
		
		// your computer can only do one thing at a time
		System.out.println("Im the main thread");
	}
	
	// what our lambdas are:
//	public void _() {
//		//System.out.println("I'm a thread!");
//		testStuff();
//	}
	
	public static void testStuff() {
		System.out.println(Sub.testNum); // the static block wont run until something
		// that lives specifically in Sub is referenced in some way
		// ID lives in SUper, so it ignores the Sub class and jumps straight to Super
		System.out.println(Sub.ID);
		
		int i = 0;
		while(i < 2)
			System.out.println("Something " + i++);
		
		for (int j = 0; j < 1; j++) 
			System.out.println("Something else " + j);
		
		do
			System.out.println("Somethign else else " + i++);
		while (i < 4);
	}
	
	public static void fileIO() {
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
