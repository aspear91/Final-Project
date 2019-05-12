package com.promineotech.dnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.dnd.entity.Character;
import com.promineotech.dnd.service.CharacterService;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCharacter(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getCharacterById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getCharacters() {
		return new ResponseEntity<Object>(service.getCharacters(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createCharacter(@RequestBody Character character) {
		return new ResponseEntity<Object>(service.createCharacter(character), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateCharacter(@RequestBody Character character, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateCharacter(character, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCharacter(@PathVariable Long id) {
		try {
			service.deleteCharacter(id);
			return new ResponseEntity<Object>("Succesfully deleted character with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
