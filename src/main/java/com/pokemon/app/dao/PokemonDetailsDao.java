package com.pokemon.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonDetails;

@Repository
public interface PokemonDetailsDao extends JpaRepository<PokemonDetails, Integer>{
	
	PokemonDetails findByNameIgnoreCase(String pokemonName);

}
