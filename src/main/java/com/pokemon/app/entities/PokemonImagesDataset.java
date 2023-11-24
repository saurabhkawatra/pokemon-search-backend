package com.pokemon.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonImagesDataset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String pokemonName;
	
	@Lob
	@Column(length = 50000000)
	@ToString.Exclude
	private byte[] pokemonImage;
	
	@ManyToOne
	PokemonExtensiveDetails pokemonExtensiveDetails;
	
	@ManyToOne
	PokemonDetails pokemonDetails;
}
