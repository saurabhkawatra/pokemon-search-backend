package com.pokemon.app.medicare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokemon.app.medicare.entities.Item;

@Repository
public interface MedicareRepositoryIntf extends JpaRepository<Item, Integer>{
	
	@Query(value = "select * from medicare.user", nativeQuery = true)
	List<Object[]> getAllItems();
}
