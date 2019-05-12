package com.promineotech.dnd.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.dnd.entity.Character;
//import com.promineotech.dnd.entity.Creature;
import com.promineotech.dnd.repository.CharacterRepository;

@Service
public class CharacterService {

	private static final Logger logger = LogManager.getLogger(CharacterService.class);
	
	@Autowired
	private CharacterRepository repo;
	
	public Character getCharacterById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to retrieve character: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Character> getCharacters() {
		return repo.findAll();
	}
	
	public Character createCharacter(Character character) {
		return repo.save(character);
	}
	
	public Character updateCharacter(Character character, Long id) throws Exception {
		try {
			Character oldCharacter = repo.findOne(id);
			oldCharacter.setName(character.getName());
			oldCharacter.setRace(character.getRace());
			oldCharacter.setCharacterLevel(character.getCharacterLevel());
			return repo.save(oldCharacter);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update character: " + id, e);
			throw new Exception("Unable to update character.");
		}
	}
	

/*	public Character rewardCharacter(Long id, int experience) throws Exception {
		try {
			Character oldCharacter = repo.findOne(id);
			oldCharacter.setExperience(distributeReward);
			return new oldCharacter
		} catch (Exception e) {
			
		}
	}*/
	
/*	public Character distributeReward() throws Exception {
		int i = 
	}*/
	
	public void deleteCharacter(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to delete customer: " + id, e);
			throw new Exception("Unable to delete character.");
		}
	}
}
