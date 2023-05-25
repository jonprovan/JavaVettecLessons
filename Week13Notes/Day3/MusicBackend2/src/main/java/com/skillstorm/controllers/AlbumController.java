package com.skillstorm.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
//	@PostMapping
//	// you can add HTTP status codes to inform your user what happened (https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public Album addAlbum(@RequestBody Album album) {
//		return repo.save(album);
//	}
	
	@PostMapping
	public ResponseEntity<String> addAlbum(@RequestBody Album album) {
		// if the record with that id already exists, don't overwrite it
		if (repo.existsById(album.getAlbumId())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album with id " + album.getAlbumId() + " already exists!");
		// if it doesn't, add a new one
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body("Album with id " + repo.save(album).getAlbumId() + " has been inserted.");
		}
	}
	
	
	// this is an endpoint for updating an existing record
	@PutMapping("/{id}")
	public ResponseEntity<String> updateAlbum(@PathVariable int id,
											  @RequestParam(name = "title", required = false) String title,
											  @RequestParam(name = "artist", required = false) String artist,
											  @RequestParam(name = "genre", required = false) String genre,
											  @RequestParam(name = "label", required = false) String label,
											  @RequestParam(name = "trackCount", required = false) String trackCount) {
		
		if(repo.findById(id).isPresent()) {
			
			// save current record to a temp object
			Album temp = repo.findById(id).get();
			
			// check for null and insert RequestParams into the temp object
			if(title != null) {
				temp.setTitle(title);
			}
			
			if(artist != null) {
				temp.setArtist(artist);
			}
			
			if(genre != null) {
				temp.setGenre(genre);
			}
			
			if(label != null) {
				temp.setLabel(label);
			}
			
			if(trackCount != null) {
				temp.setTrackCount(Integer.valueOf(trackCount));
			}
			// return the correct RE while saving the updated record
			return ResponseEntity.status(HttpStatus.OK).body("Album with id " + repo.save(temp).getAlbumId() + " has been updated.");
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album with id " + id + " does not exist!");
		}
	}
	
	
	// an endpoint for deleting a specific album via its ID
	// same PathVariable system as our getAlbumById method
//	@DeleteMapping("/{id}")
//	// the deleteById repo method returns void, so we use a 204 (No Content) status and don't need a return type
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//	public void deleteAlbum(@PathVariable int id) {
//		repo.deleteById(id);
//	}
	
	// bad practice to do it this way -- you don't want your user to just delete records by typing in a URL
	@DeleteMapping("/{id}")
	// a ResponseEntity is a way to build an HttpReponse where we can assign different statuses and content for different results
	// the type of the RE is whatever we want to put in the body
	public ResponseEntity<String> deleteAlbumByPathId(@PathVariable int id) {
		// checking if the record with the given id exists in the database
		if (repo.existsById(id)) {
			// if so, delete the record
			repo.deleteById(id);
			// and build out a RE with the correct status and body
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Album with id of " + id + " was successfully deleted.");
		} else {
			// otherwise, build a different one
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album with id of " + id + " does not exist!");
		}
	}
	
	// this deletes an object sent in the request body
	@DeleteMapping
	// returning REs because we have different possible results; taking in the Album from the body
	public ResponseEntity<String> deleteAlbumByBodyContent(@RequestBody Album album) {
		// checking that the record with the given id exists AND that it's fully equal to the sent album
		// .equals() method overridden in Album model!!
		if (repo.findById(album.getAlbumId()).isPresent() &&
				album.equals(repo.findById(album.getAlbumId()).get())) {
			repo.delete(album);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Album sent was successfully deleted.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Album sent does not exist!");
		}
	}
	
	
	

}
