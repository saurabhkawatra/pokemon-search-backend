package com.pokemon.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pokemon.app.dao.PokemonDetailsDao;
import com.pokemon.app.dao.PokemonEvolutionDataDao;
import com.pokemon.app.dao.PokemonExtensiveDetailsDao;
import com.pokemon.app.dao.PokemonImagesDatasetDao;
import com.pokemon.app.entities.PokemonDetails;
import com.pokemon.app.entities.PokemonEvolutionData;
import com.pokemon.app.entities.PokemonExtensiveDetails;
import com.pokemon.app.medicare.repository.MedicareRepositoryIntf;
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
	@Autowired
	PokemonEvolutionDataDao pokemonEvolutionDataDao;
	
//	MEDICARE REPO SECONDARY DATASOURCE
	@Autowired
	MedicareRepositoryIntf medicareRepositoryIntf;
	
	@RequestMapping(value = "/runPokemonImagesFilesReadAndWriteToPokemonImagesDataset")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public String runPokemonImagesFilesReadAndWriteToPokemonImagesDataset() {
		pokemonImagesFilesReadAndWriteToPokemonImagesDataset.tempTask();
		return "run ok";
	}
	
//	************************************************************************************************************************************************************************************************
//									PokemonDetails API's
//	************************************************************************************************************************************************************************************************
	
	@RequestMapping(value = "/getPokemonDetailsById/{id}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public PokemonDetails getPokemonDetailsById(@PathVariable(name = "id") int id) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonDetailsDao.findById(id).get();
	}
	
	@RequestMapping(value = "/getPokemonDetailsByName/{name}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public PokemonDetails getPokemonDetailsByName(@PathVariable(name = "pokemonName") String pokemonName) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonDetailsDao.findByNameIgnoreCase(pokemonName);
	}
	
	@RequestMapping(value = "/searchPokemonDetailsByNameLike/{pokemonNameLikeSearchKey}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<PokemonDetails> searchPokemonDetailsByNameLike(@PathVariable(name = "pokemonNameLikeSearchKey") String pokemonNameLikeSearchKey) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonDetailsDao.findTop10ByNameIgnoreCaseContaining(pokemonNameLikeSearchKey);
	}
	
	@RequestMapping(value = "/getPokemonDetailsWithLimitAndOffset", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<PokemonDetails> getPokemonDetailsWithLimitAndOffset(@RequestParam(name = "limit") int limit, @RequestParam(name = "offset") Integer offset) throws Exception {
		
//		Setting offset as 0 if it is not passed as a Parameter in the request
		if(offset == null) {
			offset = 0;
		}
		
		if(limit > 50 || limit <= 0) {
			Exception e = new Exception("Limit cannot be greater than 50 or less than 0");
			throw e;
		} else if(offset < 0) {
			Exception e = new Exception("Offset cannot be less than 0");
			throw e;
		} else {
			return pokemonDetailsDao.getDetailsOffestResults(limit, offset);
		}
		
	}
	
//	************************************************************************************************************************************************************************************************
//									PokemonExtensiveDetails API's
//	************************************************************************************************************************************************************************************************
	
	@RequestMapping(value = "/getPokemonExtensiveDetailsById/{id}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public PokemonExtensiveDetails getPokemonExtensiveDetailsById(@PathVariable(name = "id") int id) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonExtensiveDetailsDao.findById(id).get();
	}
	
	@RequestMapping(value = "/getPokemonExtensiveDetailsByName/{pokemonName}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public PokemonExtensiveDetails getPokemonExtensiveDetailsByName(@PathVariable(name = "pokemonName") String pokemonName) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonExtensiveDetailsDao.findByNameIgnoreCase(pokemonName);
	}
	
	@RequestMapping(value = "/searchPokemonExtensiveDetailsByNameLike/{pokemonNameLikeSearchKey}")
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<PokemonExtensiveDetails> searchPokemonExtensiveDetailsByNameLike(@PathVariable(name = "pokemonNameLikeSearchKey") String pokemonNameLikeSearchKey) {
//		return pokemonExtensiveDetailsDao.findAll().subList(0, 9);
		return pokemonExtensiveDetailsDao.findTop10ByNameIgnoreCaseContaining(pokemonNameLikeSearchKey);
	}
	
	@RequestMapping(value = "/getPokemonExtensiveDetailsWithLimitAndOffset", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "*")
	public List<PokemonExtensiveDetails> getPokemonExtensiveDetailsWithLimitAndOffset(@RequestParam(name = "limit") int limit, @RequestParam(name = "offset", required = false) Integer offset) throws Exception {

//		Setting offset as 0 if it is not passed as a Parameter in the request
		if(offset == null) {
			offset = 0;
		}
		
		if(limit > 50 || limit <= 0) {
			Exception e = new Exception("Limit cannot be greater than 50 or less than 0");
			throw e;
		} else if(offset < 0) {
			Exception e = new Exception("Offset cannot be less than 0");
			throw e;
		} else {
			return pokemonExtensiveDetailsDao.getExtensiveDetailsOffestResults(limit, offset);
		}
	}
	
	
//	************************************************************************************************************************************************************************************************
//									PokemonEvolutionData API's
//  ************************************************************************************************************************************************************************************************
	
	@RequestMapping(value = "/getAllPokemonEvolutionData", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "*")
	List<PokemonEvolutionData> getAllPokemonEvolutionData() {
		return pokemonEvolutionDataDao.findAll();
	}
	
//	@RequestMapping(value = "/setAllPokemonEvolutionDataAndPokemonExtensiveDetails", method = RequestMethod.GET)
//	@ResponseBody
//	@CrossOrigin(origins = "*")
//	List<PokemonEvolutionData> setAllPokemonEvolutionDataAndPokemonExtensiveDetails() {
//		pokemonEvolutionDataDao.findAll().stream().forEach(pokEvoData -> {
//			if(!pokEvoData.getStageOne().equals("") && null != pokEvoData.getStageOne()) {
//				PokemonExtensiveDetails stgOnePokExtDet = pokemonExtensiveDetailsDao.findByNameIgnoreCase(pokEvoData.getStageOne());
//				pokEvoData.setStageOnePokemonExtensiveDetails(stgOnePokExtDet);
//			}
//			if(!pokEvoData.getStageTwo().equals("") && null != pokEvoData.getStageTwo()) {
//				PokemonExtensiveDetails stgTwoPokExtDet = pokemonExtensiveDetailsDao.findByNameIgnoreCase(pokEvoData.getStageTwo());
//				pokEvoData.setStageTwoPokemonExtensiveDetails(stgTwoPokExtDet);
//			}
//			if(!pokEvoData.getStageThree().equals("") && null != pokEvoData.getStageThree()) {
//				PokemonExtensiveDetails stgThreePokExtDet = pokemonExtensiveDetailsDao.findByNameIgnoreCase(pokEvoData.getStageThree());
//				pokEvoData.setStageThreePokemonExtensiveDetails(stgThreePokExtDet);
//			}
//			pokemonEvolutionDataDao.save(pokEvoData);
//		});
//		return pokemonEvolutionDataDao.findAll();
//	}


//  ************************************************************************************************************************************************************************************************
//  TESTING MEDICARE DATASOURCE         MedicareData API's
//  ************************************************************************************************************************************************************************************************

	@RequestMapping(value = "/getAllMedicareUsers", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin(origins = "*")
	List<Object[]> getAllMedicareUsers() {
		return medicareRepositoryIntf.getAllItems();
	}
	
}