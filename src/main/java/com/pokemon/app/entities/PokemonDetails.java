package com.pokemon.app.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PokemonDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	
	@OneToMany
	List<PokemonImagesDataset> pokemonImageSetDetails;
}
