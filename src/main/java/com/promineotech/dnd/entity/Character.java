package com.promineotech.dnd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.promineotech.dnd.util.LevelExperienceRequirements;
import com.promineotech.dnd.util.RaceMultiplier;

@Entity
public class Character {

	private Long id;
	private String name;
	private RaceMultiplier race;
	private LevelExperienceRequirements characterLevel;
	private int experience;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RaceMultiplier getRace() {
		return race;
	}

	public void setRace(RaceMultiplier race) {
		this.race = race;
	}

	public LevelExperienceRequirements getCharacterLevel() {
		return characterLevel;
	}

	public void setCharacterLevel(LevelExperienceRequirements characterLevel) {
		this.characterLevel = characterLevel;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
}
