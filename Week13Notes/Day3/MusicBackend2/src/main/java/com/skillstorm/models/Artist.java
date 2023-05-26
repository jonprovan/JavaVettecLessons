package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private int artistId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "founded")
	private int founded;
	
	public Artist() {}

	public Artist(int artistId, String name, String type, int founded) {
		super();
		this.artistId = artistId;
		this.name = name;
		this.type = type;
		this.founded = founded;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFounded() {
		return founded;
	}

	public void setFounded(int founded) {
		this.founded = founded;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return artistId == other.artistId && founded == other.founded && Objects.equals(name, other.name)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", name=" + name + ", type=" + type + ", founded=" + founded + "]";
	}
	
}
