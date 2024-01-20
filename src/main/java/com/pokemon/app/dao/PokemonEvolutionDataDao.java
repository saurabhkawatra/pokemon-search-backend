package com.pokemon.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonEvolutionData;

@Repository
public interface PokemonEvolutionDataDao extends JpaRepository<PokemonEvolutionData, Integer> {

}
