package com.promineotech.dnd.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.dnd.entity.Character;

public interface CharacterRepository  extends CrudRepository<Character, Long>{

}
