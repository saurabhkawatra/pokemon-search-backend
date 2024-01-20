package com.pokemon.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonExtensiveDetails;

@Repository
public interface PokemonExtensiveDetailsDao extends JpaRepository<PokemonExtensiveDetails, Integer>{
	
	PokemonExtensiveDetails findByNameIgnoreCase(String pokemonName);
	
	@Query(value = "select * from pokemon_search_app.pokemon_extensive_details order by id limit ?1 offset ?2", nativeQuery = true)
	List<PokemonExtensiveDetails> getExtensiveDetailsOffestResults(int limit, int offset);
	
	List<PokemonExtensiveDetails> findTop10ByNameIgnoreCaseContaining(String pokemonNameLikeSearchKey);

}
