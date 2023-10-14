package com.pokemon.app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
public class pokemonDetails {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.SEQUENCE)
	private int id;
	
	private String name;
	private String type;
	private String characteristic;
	private int total;
	private int hp;
	private int attack;
	private int defence;
	private int specialAttack;
	private int specialDefence;
	private int speed;
	private String generation;
	private String legendary;
}
