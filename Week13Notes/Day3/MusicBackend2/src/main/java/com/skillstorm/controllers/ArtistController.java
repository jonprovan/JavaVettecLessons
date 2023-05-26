package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Artist;
import com.skillstorm.repositories.ArtistRepository;

@RestController
@RequestMapping("/artist")
@CrossOrigin(origins = "*")
public class ArtistController {
	
	@Autowired
	private ArtistRepository repo;
	
	@GetMapping
	public Iterable<Artist> getAllArtists() {
		return repo.findAll();
	}

}
