package com.skillstorm.producerconsumer;

public class ProducerConsumer {
	// going to house the code for our producer and our consumer
	// going to house the shared resource they are producing to and 
	// consuming from
	
	private Object mutex = new Object();
	private int availableData;
	
	public ProducerConsumer() {
		this.availableData = 0;
	}
	
	// the method the producer will use to produce data
	public void produce(int data) {
		synchronized(mutex) {
			System.out.println(Thread.currentThread() + " is producing " + data);
			// critical section
			availableData += data;
			
			// any threads that are waiting on the mutex will not wake up
			// until you tell them you are done
			// any threads waiting on this object are woken up
			// whichever thread grabs the lock first progresses
			mutex.notifyAll();
		}
	}
	
	// the method the consumer will use to consume data
	public void consume(int data) {
		synchronized (mutex) {
			// no gaurantee the data it would like to consume is available
			System.out.println(Thread.currentThread() + " wants to consume " + data);
			
			// if the data is not available the thread needs to wait
			// our consume cannot leave the critical section if it does not
			// consume the data it needs
			// the code for both procuders and consumers still need the lock to continue
			
			while (availableData < data) {
				// wait
				System.out.println(Thread.currentThread() + " is waiting to consume");
				
				try {
					// instructs the thread that holds the lock to release it
					// the wait method also handles our threads re-grabbing the lock
					// when they wake up. If they don't re-grab it they keep waiting
					mutex.wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				
				System.out.println(Thread.currentThread() + " woke up");
			}
			
			System.out.println(Thread.currentThread() + " consumed " + data);
			// critical section
			availableData -= data;
		}
	}
}
