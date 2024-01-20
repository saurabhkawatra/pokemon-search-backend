package com.pokemon.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonDetails;

@Repository
public interface PokemonDetailsDao extends JpaRepository<PokemonDetails, Integer>{
	
	PokemonDetails findByNameIgnoreCase(String pokemonName);
	
	@Query(value = "select * from pokemon_search_app.pokemon_details order by id limit ?1 offset ?2", nativeQuery = true)
	List<PokemonDetails> getDetailsOffestResults(int limit, int offset);
	
	List<PokemonDetails> findTop10ByNameIgnoreCaseContaining(String pokemonNameLikeSearchKey);

}
