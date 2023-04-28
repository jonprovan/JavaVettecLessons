package com.skillstorm.beans;

public class BankAccount2 {

	private double balance;
	
	public BankAccount2(double balance) {
		this.balance = balance;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	// you can synchronize a block of code, to do that you need an object to lock on
	// you dont need to synchronize on just a block of code
	// you can synchronize an entire method as well
	// for a block only one thread at a time can run that block, for a method
	// only one thread at a time can run that method
	public synchronized double addMoney(double amount) {
		balance += amount;
		
		return balance;
	}
	
	public synchronized double withdrawMoney(double amount) {
		if (amount <= balance) {
			balance -= amount;
		}
		
		return balance;
	}
}
