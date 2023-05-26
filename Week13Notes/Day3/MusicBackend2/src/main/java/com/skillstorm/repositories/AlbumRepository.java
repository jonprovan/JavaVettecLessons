package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Album;

// we need this to designate this interface as a Repository bean
// this allows it to be injected elsewhere
// this repository automatically generates all the CRUD operations we'll need for this specific table
@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {
	
	// you can write your own queries using JPQL -- Java Persistence Query Language
	// it's similar to SQL but not quite the same
	// you can use to modify the stock queries going from your repo to your database
	
	
	// the Query annotation outlines what query this method sends to the database when it is run
	// the value is the query itself' nativeQuery tells us this a native SQL query
	// some modifications are necessary for this syntax
	// for instance, we don't need quotes or parentheses around our LIKE value
	// ?1 = the first parameter fed in, ?2 would be a second, if we had it
	@Query(value = "SELECT * FROM album WHERE title LIKE %?1%", nativeQuery = true)
	// declare your method; this is an interface, so we can't include implementation
	public Iterable<Album> findByTitleSearchString(String searchString);
	
	@Query(value = "SELECT * FROM album WHERE artist LIKE %?1%", nativeQuery = true)
	public Iterable<Album> findByArtistSearchString(String searchString);
	
	
	
	// another example:
	// @Query("SELECT t FROM album a JOIN a.title t WHERE a.id = :id")
	// :id and ?1 are parameter placeholders

}
