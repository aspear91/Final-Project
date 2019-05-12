package com.promineotech.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.dnd.entity.Creature;
import com.promineotech.dnd.service.CreatureService;

@RestController
@RequestMapping("/creatures")
public class CreatureController {
	
	@Autowired
	private CreatureService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getCreature(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getCreatureById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getCreatures() {
		return new ResponseEntity<Object>(service.getCreatures(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createCreature(@RequestBody Creature creature) {
		return new ResponseEntity<Object>(service.createCreature(creature), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateCreature(@RequestBody Creature creature, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateCreature(creature, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCreature(@PathVariable Long id) {
		try {
			service.deleteCreature(id);
			return new ResponseEntity<Object>("Succesfully feleted creature with id: " +id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
