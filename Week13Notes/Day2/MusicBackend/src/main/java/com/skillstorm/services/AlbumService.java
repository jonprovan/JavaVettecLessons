package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Album;
import com.skillstorm.repositories.AlbumRepository;

// a service is an injectable bean that can extend the functionality of stock repository methods

// we need this to designate this class as a service
@Service
public class AlbumService {
	
	// this automatically injects the following repo into this class whenever it is needed
	@Autowired
	private AlbumRepository repo;
	
	// we can write extensions of (or simple duplications of) repository methods
	public Iterable<Album> getAll() {
		return repo.findAll();
	}

}
