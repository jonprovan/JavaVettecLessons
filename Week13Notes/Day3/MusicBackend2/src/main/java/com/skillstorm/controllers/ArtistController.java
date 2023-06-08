package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Album;
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
	
	@PostMapping
	public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
		// if the record with that id already exists, don't overwrite it
		if (repo.existsById(artist.getArtistId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(artist);
		// if it doesn't, add a new one
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(artist));
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Artist> deleteArtist(@RequestBody Artist artist) {
		if (repo.findById(artist.getArtistId()).isPresent() &&
				artist.equals(repo.findById(artist.getArtistId()).get())) {
			repo.delete(artist);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(artist);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(artist);
		}
	}
	
	@PutMapping
	public Artist updateArtist(@RequestBody Artist artist) {
		return repo.save(artist);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
