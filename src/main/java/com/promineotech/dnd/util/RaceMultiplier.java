package com.promineotech.dnd.util;

public enum RaceMultiplier {

	Human(1),
	Lizardfolk(.9),
	Ork(.9),
	Dwarf(1),
	Elf(1);
	
	private double raceMultiplier;
	
	RaceMultiplier(double raceMultiplier) {
		this.raceMultiplier = raceMultiplier;
	}
	
	public double getRaceMultiplier() {
		return raceMultiplier;
	}
}
