package com.skillstorm.producerconsumer;

import java.util.Random;

public class Main {

	/*
	 * Common concurrency issues:
	 * 
	 * 	race conditions: unintended outcomes that depend on which thread is faster
	 * 					 (ex/ "this will succeed if this thread is faster")
	 * 
	 * 	deadlocks: two or more threads are blocked, waiting on a resource another thread
	 * 			   holds. They wait forever
	 * 
	 *  starvation: a thread is unable to access a resource it needs to continue it's 
	 *  			process, so it gets stuck
	 *  
	 *  livelocks: very similar to deadlocks. two or more threads are trying to access
	 *  		   a resource that another thread holds, and continue retrying.
	 */
	
	// a design pattern involving two or more threads, atleast one producer
	// and atleast one consumer
	// the producer thread/threads produce some data
	// the consumer thread/threads consume that data
	public static void main(String[] args) {
		// our producer and consumer will produce/ consume a random amount
		// of data
		Random rand = new Random();
		ProducerConsumer pcExample = new ProducerConsumer();
		
		Thread producer = new Thread(() -> {
			int data;
			
			try {
				for (int i = 0; i < 5; i++) {
					// (high + 1 - low) + low
					data = rand.nextInt(51 - 20) + 20;
					
					pcExample.produce(data);
					Thread.sleep(1000);
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		Thread consumer = new Thread(() -> {
			int data;
			
			try {
				for (int i = 0; i < 5; i++) {
					data = rand.nextInt(21 - 10) + 10;
					
					pcExample.consume(data);
					Thread.sleep(1000);
				}
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
