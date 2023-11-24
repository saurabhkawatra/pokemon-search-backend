package com.pokemon.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.app.entities.PokemonImagesDataset;

@Repository
public interface PokemonImagesDatasetDao extends JpaRepository<PokemonImagesDataset, Integer>{

}
