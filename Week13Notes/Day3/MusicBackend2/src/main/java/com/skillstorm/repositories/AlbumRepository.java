package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Album;

// we need this to designate this interface as a Repository bean
// this allows it to be injected elsewhere
// this repository automatically generates all the CRUD operations we'll need for this specific table
@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
