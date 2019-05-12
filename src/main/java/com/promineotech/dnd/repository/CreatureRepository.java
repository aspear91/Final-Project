package com.promineotech.dnd.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.dnd.entity.Creature;

public interface CreatureRepository  extends CrudRepository<Creature, Long>{

}
