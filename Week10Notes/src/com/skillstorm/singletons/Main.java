package com.skillstorm.singletons;

public class Main {

	public static void main(String[] args) {
		// outside of the method call it's the same instance
//		singletons();
//		RingOfPower theRing = RingOfPower.getInstance(7);
//		System.out.println("Main ring: " + theRing);
		
		//singletonsInThreads();
		//threadSafeSingletons();
		threadSafeSingletonsInThreads();
	}
	
	public static void threadSafeSingletonsInThreads() {
		Thread thread1 = new Thread(() -> {
			TrueRingOfPower ring = TrueRingOfPower.getInstance();
			System.out.println(ring + ": " + ring.getAbilities());
			ring.dominateWill();
			ring.superSpeed();
			ring.invisibility();
		});
		
		Thread thread2 = new Thread(() -> {
			TrueRingOfPower ring2 = TrueRingOfPower.getInstance(25);
			System.out.println(ring2 + ": " + ring2.getAbilities());
			ring2.dominateWill();
			ring2.superSpeed();
			ring2.invisibility();
		});
		
		Thread thread3 = new Thread(() -> {
			TrueRingOfPower ring3 = TrueRingOfPower.getInstance(34);
			System.out.println(ring3 + ": " + ring3.getAbilities());
			ring3.dominateWill();
			ring3.superSpeed();
			ring3.invisibility();
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void threadSafeSingletons() {
		// this is still single threaded as ive written it
		for (int i = 0; i < 3; i++) {
			TrueRingOfPower temp = TrueRingOfPower.getInstance(14);
			System.out.println(temp + ": " + temp.getAbilities());
		}
		
		TrueRingOfPower theRing = TrueRingOfPower.getInstance(21);
		TrueRingOfPower theRing2 = TrueRingOfPower.getInstance(42);
		TrueRingOfPower theRing3 = TrueRingOfPower.getInstance(84);
		
		System.out.println(theRing + ": " + theRing.getAbilities());
		System.out.println(theRing2 + ": " + theRing2.getAbilities());
		System.out.println(theRing3 + ": " + theRing3.getAbilities());
	}
	
	// our implementation is not thread safe
	public static void singletonsInThreads() {
		// this creates a race condition
		// if one thread is faster this works as intended, but if they are
		// about the same speed we can get multiple instances
		Thread thread1 = new Thread(() -> {
			RingOfPower theRing = RingOfPower.getInstance(4);
			System.out.println(theRing + ": " + theRing.getAbilities());
		});
		
		Thread thread2 = new Thread(() -> {
			RingOfPower theRing2 = RingOfPower.getInstance(105);
			System.out.println(theRing2 + ": " + theRing2.getAbilities());
		});
		
		Thread thread3 = new Thread(() -> {
			RingOfPower theRing3 = RingOfPower.getInstance(27);
			System.out.println(theRing3 + ": " + theRing3.getAbilities());
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void singletons() {
		// Singleton is a design pattern where you only allow a single instance
		// of an object to be created
		
		// inside of a loop, this also returns the same object after the first call
		for (int i = 0; i < 3; i++) {
			RingOfPower temp = RingOfPower.getInstance(3);
			System.out.println(temp);
		}
		
		RingOfPower theRing = RingOfPower.getInstance(7);
		theRing = null; // this does not change the instance that is returned
		
		RingOfPower theRing2 = RingOfPower.getInstance(12);
		RingOfPower theRing3 = RingOfPower.getInstance(72);
		
		// can grab the hashcode to make sure these are unique
		System.out.println(theRing);
		//System.out.println(theRing.getAbilities());
		
		// this call won't change anything about the ring, it just returns the 
		// first one
		theRing = RingOfPower.getInstance(3);
		
		System.out.println(theRing);
		System.out.println(theRing.getAbilities());
		
		System.out.println(theRing2);
		System.out.println(theRing3);
	}
}
