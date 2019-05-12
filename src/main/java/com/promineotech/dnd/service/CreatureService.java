package com.promineotech.dnd.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.dnd.entity.Creature;
import com.promineotech.dnd.repository.CreatureRepository;

@Service
public class CreatureService {

	private static final Logger logger = LogManager.getLogger(CreatureService.class);
	
	@Autowired
	private CreatureRepository repo;
	
	public Creature getCreatureById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to retrieve creature: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Creature> getCreatures() {
		return repo.findAll();
	}
	
	public Creature createCreature(Creature creature) {
		return repo.save(creature);
	}
	
	public Creature updateCreature(Creature creature, Long id) throws Exception {
		try {
			Creature oldCreature = repo.findOne(id);
			oldCreature.setName(creature.getName());
			oldCreature.setExpReward(creature.getExpReward());
			oldCreature.setLevel(creature.getLevel());
			return repo.save(oldCreature);
		} catch (Exception e) {
			logger.error("Exception occured while trying to update creature: " + id, e);
			throw new Exception("Unable to update creature.");
		}
	}
	
	public void deleteCreature(Long id) throws Exception {
		try {
			repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to delete creature: " + id, e);
			throw new Exception("Unable to delete creature.");
		}
	}
}
