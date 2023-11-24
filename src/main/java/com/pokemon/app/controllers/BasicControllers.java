package com.pokemon.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pokemon.app.dao.PokemonDetailsDao;
import com.pokemon.app.dao.PokemonExtensiveDetailsDao;
import com.pokemon.app.dao.PokemonImagesDatasetDao;
import com.pokemon.app.entities.PokemonExtensiveDetails;
import com.pokemon.app.utils.PokemonImagesFilesReadAndWriteToPokemonImagesDataset;

@Controller
public class BasicControllers {
	
	@Autowired
	PokemonImagesFilesReadAndWriteToPokemonImagesDataset pokemonImagesFilesReadAndWriteToPokemonImagesDataset;
	
	@Autowired
	PokemonDetailsDao pokemonDetailsDao;
	@Autowired
	PokemonExtensiveDetailsDao pokemonExtensiveDetailsDao;
	@Autowired
	PokemonImagesDatasetDao pokemonImagesDatasetDao;
	
	@RequestMapping(value = "/runPokemonImagesFilesReadAndWriteToPokemonImagesDataset")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public String runPokemonImagesFilesReadAndWriteToPokemonImagesDataset() {
		pokemonImagesFilesReadAndWriteToPokemonImagesDataset.tempTask();
		return "run ok";
	}
	
	@RequestMapping(value = "/getAllPokemonDetails")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<PokemonExtensiveDetails> getAllPokemonExtensiveDetails() {
		return pokemonExtensiveDetailsDao.findAll();
	}
	

}
