package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Album;

// a repository is a preset bunch of methods for calling to a database
// we don't need to write any code here at all

// indicates this is a repository
@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
