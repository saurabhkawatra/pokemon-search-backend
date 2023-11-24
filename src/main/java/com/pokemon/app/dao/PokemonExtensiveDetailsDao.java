package com.pokemon.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonExtensiveDetails;

@Repository
public interface PokemonExtensiveDetailsDao extends JpaRepository<PokemonExtensiveDetails, Integer>{
	
	PokemonExtensiveDetails findByNameIgnoreCase(String pokemonName);

}
