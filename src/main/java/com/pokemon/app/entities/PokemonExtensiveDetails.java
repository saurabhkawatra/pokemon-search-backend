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
public class PokemonExtensiveDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String name;
	private String type_one;
	private String type_two;
	private String weight_kg;
	private String height_m;
	private String classfication;
	private String abilities;
	private String speed;
	private String generation;
	private String hp;
	private String attack;
	private String defense;
	private String sp_attack;
	private String sp_defense;
	private String against_water;
	private String against_steel;
	private String against_rock;
	private String against_psychic;
	private String against_poison;
	private String against_normal;
	private String against_ice;
	private String against_ground;
	private String against_grass;
	private String against_ghost;
	private String against_flying;
	private String against_fire;
	private String against_fight;
	private String against_fairy;
	private String against_electric;
	private String against_dragon;
	private String against_bug;
	private String against_dark;
	private String is_legendary;
	private String pokedex_number;
	private String percentage_male;
	private String experience_growth;
	private String capture_rate;
	private String base_total;
	private String base_happiness;
	private String base_egg_steps;
	
	@OneToMany
	List<PokemonImagesDataset> pokemonImageSetDetails;
	
}
