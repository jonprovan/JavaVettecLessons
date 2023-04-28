package com.skillstorm.beans;

public class Person {

	private BankAccount account;
	private String name;
	
	public Person(String name, BankAccount account) {
		this.account = account;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void add(double amount) {
		// dont need to synchronize this because the method already does that
		double newBalance = this.account.addMoney(amount);
		System.out.println(this.name + " deposited " + amount + ", the new balance is " + newBalance);
	}
	
	public void withdraw(double amount) {
		// dont need to synchronize this because the method already does that
		double newBalance = this.account.withdrawMoney(amount);
		System.out.println(this.name + " withdrew " + amount + ", the new balance is " + newBalance);
	}
}
