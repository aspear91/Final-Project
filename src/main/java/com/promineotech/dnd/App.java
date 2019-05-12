package com.promineotech.dnd;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.promineotech.dnd")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}


/*

This API will Host a Party of Characters that each receive experience points per encounter, 
which will be received after each characters race has determined what kind of experience
multiplier they have. The experience multipliers will be an enum that has percentage's 
appended to the race names. Also, the level disparity between the characters and the creatures
defeated in each encounter will factor in percentage-wise: more for each level the creature has
over the characters, and less for each level the character has over the creature.

Character with a GET POST PUT DELETE
GET: Characters
GET: Characters/{id}
POST: Characters
PUT: Characters/{id}
DELETE: Characters/{id}

- private Long id:
- private String name:
- private Race race: The race enum will have experience multipliers
- private CharacterLevel level: the characterLevel enum will determine the amount of exp needed to gain each level.

**REQUESTS**

POST http://localhost:8080/characters
{
	"name": "Kashaar",
	"race": "Human",
	"level": "5"
}

POST http://localhost:8080/characters
{
	"name": "Rakshar",
	"race": "LizardFolk",
	"level": "1"
}

Creature with a GET POST PUT DELETE
GET: Creatures
GET: Creatures/{id}
POST: Creatures
PUT: Creatures/{id}
DELETE: Creatures/{id}

- private Long id:
- private String name:
- private Integer exp: amount of exp a particular creature rewards.
- private CreatureLevel level: the experimental CreatureLevel enum is a comparison value for characters to determine how much bonus exp they get based on level disparity to creatures.

**REQUESTS**
POST http://localhost:8080/creatures
{
	"name": "Goblin",
	"exp": "20",
	"level": "2"
}

POST http://localhost:8080/creatures
{
	"name": "Wolf",
	"exp": "10",
	"level": "1"
}

PUT http://localhost:8080/creatures/1
{
	"name": "Goblin",
	"exp": "20",
	"level": "3"
}


Encounter with a GET POST DELETE
GET: Characters/Encounters
GET: Characters/Encounters/{id}
POST: Characters/Encounters/{creatureIds}
DELETE: Characters/Encounters/{id}

- Id:
- Creatures:



- 
*/