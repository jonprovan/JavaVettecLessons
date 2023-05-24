package com.skillstorm.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.models.Album;
import com.skillstorm.repositories.AlbumRepository;

// this class is the front line for communication into and out of your API
// HTTP requests come in from the front end, HTTP Responses are sent back to the front end

// this states that this class is a controller AND that all outgoing communication is wrapped in an HTTPResponseBody
@RestController
// this states that all incoming requests with our base URL and this suffix will go to this controller
@RequestMapping("/album")
// this restricts incoming traffic to the sources designated, in this case, * = everywhere
@CrossOrigin("*")
public class AlbumController {
	
	// this injects our corresponding repo wherever we need it, can be private because we're only using it here
	@Autowired
	private AlbumRepository repo;
	
	// this says if I receive a GET request with no additional suffix, use this method
	// this is an endpoint for GET requests to, in our case, http://localhost:8080/album
	@GetMapping
	public Iterable<Album> getAllAlbums() {
		return repo.findAll();
	}
	
	// this method is an endpoint for getting a specific Album via its ID
	// "/{id}" means, if the user puts a number after the /album/, we use that number as the PathVariable id
	@GetMapping("/{id}")
	// here, we specify that we're taking that PathVariable into the method
	public Album getAlbumById(@PathVariable int id) {
		Optional<Album> result = repo.findById(id);  // repo.findById() returns an Optional, so we have to .get() the Album out of it
		if (result.isPresent())
			return result.get();
		else
			return null;
	}
	
	/*
	 * This method sends back an HTTPResponse, the body of which is JSON = JavaScript Object Notation
	 * 
	 * A JS Object looks like this  { }
	 * If the Object has contents, it looks like this:
	 * 
	 *   {
	 *     "name": "Douglas Fairbanks",
	 *     "age": 99,
	 *     "children": [ "Meg", "Doug Jr.", "Xybot" ]
	 *   }
	 * 
	 * A JS Array looks like this   [ ]
	 * If the array has contents, it looks like   [ 1, 3, 5, 8 ]
	 * 
	 * Arrays can contain objects, and vice versa, and array contents don't have to be the same type
	 * 
	 * This particular method returns an array of JS objects
	 *
	 */
	
	
	// this is an endpoint for POST requests to, in our case, http://localhost:8080/album 
	@PostMapping
	// you can add HTTP status codes to inform your user what happened (https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Album addAlbum(@RequestBody Album album) {
		return repo.save(album);
	}
	
	
	// an endpoint for deleting a specific album via its ID
	// same PathVariable system as our getAlbumById method
	@DeleteMapping("/{id}")
	// the deleteById repo method returns void, so we use a 204 (No Content) status and don't need a return type
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAlbum(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	
	
	

}
