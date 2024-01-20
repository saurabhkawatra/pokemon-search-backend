package com.pokemon.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonEvolutionData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String StageOne;
	private String StageTwo;
	private String StageThree;
	private String pokedexNumber;
	private String genIntroduced;
	private String initialCombatPower;
	private String finalCombatPower;
	private String combatPowerIncrease;
	
	@OneToOne
	private PokemonExtensiveDetails stageOnePokemonExtensiveDetails;
	@OneToOne
	private PokemonExtensiveDetails stageTwoPokemonExtensiveDetails;
	@OneToOne
	private PokemonExtensiveDetails stageThreePokemonExtensiveDetails;
}
