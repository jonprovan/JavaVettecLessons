package com.skillstorm.athletes;

public class Athlete implements Comparable<Athlete> {

	// everything here is athlete specific, so nothing should be static
	private String name;
	private int wins;
	private int loses;
	
	public Athlete(String name, int wins, int loses) {
		this.name = name;
		this.wins = wins;
		this.loses = loses;
	}
	
	public int getTotalGames() {
		return this.wins + this.loses;
	}
	
	public double getWinRate() {
		// return the wins / total games as a percentage
		return ((double)wins / (double)(wins + loses)) * 100;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWins() {
		return this.wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getLoses() {
		return this.loses;
	}
	
	public void setLoses(int loses) {
		this.loses = loses;
	}
	
	@Override
	public String toString() {
		if (getTotalGames() < 31) {
			return String.format("[ %s: %d wins ]", this.name, this.wins);
		} else {
			return String.format("[ %s: %.2f%% ]", this.name, this.getWinRate());
		}
	}

	@Override
	public int compareTo(Athlete o) {
		if (o == null) {
			throw new NullPointerException("o is null");
		}
		
		// only compare win rate is both are above 30 games
		if (this.getTotalGames() > 30 && o.getTotalGames() > 30) {
			return (int)(this.getWinRate() - o.getWinRate());
		} else {
			return this.getWins() - o.getWins();
		}
	}
}
