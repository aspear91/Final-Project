package com.promineotech.dnd.util;

public enum LevelExperienceRequirements {

	L1(0),
	L2(100),
	L3(300),
	L4(750),
	L5(1000),
	L6(1500),
	L7(2000),
	L8(3000),
	L9(4500),
	L10(5500),
	L11(7500),
	L12(9000),
	L13(12000),
	L14(15500),
	L15(19500),
	L16(24000),
	L17(29000),
	L18(34500),
	L19(40000),
	L20(50000);
	
	private double levelExperienceRequirements;
	
	LevelExperienceRequirements(double levelExperienceRequirements) {
		this.levelExperienceRequirements = levelExperienceRequirements;
	}
	
	public double getRaceMultiplier() {
		return levelExperienceRequirements;
	}
	
}
