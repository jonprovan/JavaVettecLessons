package com.skillstorm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.models.Album;
import com.skillstorm.repositories.AlbumRepository;

// this is a service class for pre-processing data before the actual repo requests

@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository repo;
	
	// no longer necessary for Album submission
	
//	public Album artistCheck(Album album) {
//		
//		if (album.getArtist().getName().length() > 45) {
//			album.getArtist().setName(album.getArtist().getName().substring(0, 42) + "...");
//		}
//		
//		return repo.save(album);
//	}

}
