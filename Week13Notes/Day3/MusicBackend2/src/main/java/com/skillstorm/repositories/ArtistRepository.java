package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Artist;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Integer> {

}
