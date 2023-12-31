package com.skillstorm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Album;
import com.skillstorm.services.AlbumService;

@RestController
// what URL gets us to this controller?
@RequestMapping("/album")
// which request sources are allowed? * = all
@CrossOrigin(origins = "*")
public class AlbumController {
	
	// this means make this resource automatically available wherever it's needed
	@Autowired
	private AlbumService service;
	
	@GetMapping
	public Iterable<Album> findAll() {
		return service.getAll();
	}

}
