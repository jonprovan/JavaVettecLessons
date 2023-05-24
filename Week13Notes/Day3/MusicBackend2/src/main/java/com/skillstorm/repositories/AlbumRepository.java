package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;

import com.skillstorm.models.Album;

public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
