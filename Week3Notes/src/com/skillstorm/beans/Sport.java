package com.skillstorm.beans;

public class Sport extends Motorcycle {
	
	private boolean wheelie;

	public Sport(String brand, String model, String color, int topSpeed, 
			String size, boolean wheelie) {
		// sport bikes are not trikes, so we are hardcoding trike to false
		super(brand, model, color, topSpeed, size, false);
		this.wheelie = wheelie;
	}
	
	@Override
	public void drive() {
		System.out.println("Zoom Zoom!");
	}

	@Override
	public void park() {
		// because parking is just driving in reverse
		System.out.println("MooZ mooZ!");
	}

	public void doWheelie() {
		// if you can wheelie success, else oops
		if (wheelie) {
			System.out.println("Sick wheelie");
		} else {
			System.out.println("Bike's totaled");
		}
	}
	
	public boolean isWheelie() {
		return this.wheelie;
	}
	
	public void setWheelie(boolean wheelie) {
		this.wheelie = wheelie;
	}
	
	@Override
	public String toString() {
		if (this.wheelie) {
			return String.format("%s %s %s that can wheelie", getColor(), getBrand(), 
					getModel());
		} else {
			return String.format("%s %s %s that can't wheelie", getColor(), getBrand(), 
					getModel());
		}
	}
}
