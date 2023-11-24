package com.pokemon.app.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pokemon.app.dao.PokemonDetailsDao;
import com.pokemon.app.dao.PokemonExtensiveDetailsDao;
import com.pokemon.app.dao.PokemonImagesDatasetDao;
import com.pokemon.app.entities.PokemonDetails;
import com.pokemon.app.entities.PokemonExtensiveDetails;
import com.pokemon.app.entities.PokemonImagesDataset;

@Component
public class PokemonImagesFilesReadAndWriteToPokemonImagesDataset {
	
	@Autowired
	PokemonDetailsDao pokemonDetailsDao;
	
	@Autowired
	PokemonExtensiveDetailsDao pokemonExtensiveDetailsDao;
	
	@Autowired
	PokemonImagesDatasetDao pokemonImagesDatasetDao;
	
	public void tempTask() {
		File pokemonImageFolder = new File("D:\\Downloads\\pokemon all images\\Pokemon_Image_Dataset");
		try {
			for(File pokemonImage : pokemonImageFolder.listFiles()) {
				String pokemonNameWithExtension = pokemonImage.getName();
				String pokemonName = pokemonNameWithExtension.split("\\.")[0];
				byte[] pokemonImageFileData = Files.readAllBytes(pokemonImage.toPath());
				PokemonExtensiveDetails pokemonExtDet = pokemonExtensiveDetailsDao.findByNameIgnoreCase(pokemonName);
				PokemonDetails pokemonDet = pokemonDetailsDao.findByNameIgnoreCase(pokemonName);
				PokemonImagesDataset pokemonImagesDataset = new PokemonImagesDataset(0, pokemonName, pokemonImageFileData, pokemonExtDet, pokemonDet);
				pokemonImagesDatasetDao.save(pokemonImagesDataset);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
