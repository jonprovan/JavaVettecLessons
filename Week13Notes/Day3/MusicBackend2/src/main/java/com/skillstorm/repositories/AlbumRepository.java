package com.skillstorm.repositories;

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
	
	// @Query(value = "SELECT * FROM album WHERE artist LIKE ?1 ;", nativeQuery = true)
	// then you'd add your method declaration below
	
	// another example:
	// @Query("SELECT t FROM album a JOIN a.title t WHERE a.id = :id")
	// :id and ?1 are parameter placeholders

}
