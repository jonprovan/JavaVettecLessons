package com.skillstorm.beans;

public class BankAccount {
	// more like an ATM, since every thread shares this lock, 
	// no one can access the account functions while someone else is viewing
	// their account. just like standing in line for an ATM
	private static Object mutex = new Object();

	private double balance;
	
	public BankAccount(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	// need to use our methods to edit the balance
	// but each of these has a critical section
	// we dont want two threads doing this at the same time
	public double addMoney(double amount) {
		synchronized (mutex) {
			balance += amount; // critical section
		}
		
		return balance;
	}
	
	public double withdrawMoney(double amount) {
		synchronized (mutex) {
			if (amount <= balance) { // critical section
				balance -= amount; 
			} // ends the critical section
		}
		
		return balance;
	}
}
