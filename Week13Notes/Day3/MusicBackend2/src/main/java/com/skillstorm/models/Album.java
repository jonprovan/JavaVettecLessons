package com.skillstorm.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// we need properties for each field in the database table, regular Java naming conventions
// we need a no-args constructor AND an argumented constructor
// we need getters, setters, full encapsulation, etc.
// toString() optional, useful for debugging

// this annotation states that this class corresponds to a database table record
@Entity
// this one tells it which table it corresponds to
@Table(name = "album")
public class Album {
	
	// Id tells us this is a primary key
	// GeneratedValue tells us the database must generate this and how
	// Column tells us which database column this variable goes with
	// order does not matter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private int albumId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "artist")
	private String artist;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "track_count")
	private int trackCount;
	
	public Album() {}

	public Album(int albumId, String title, String artist, String genre, String label, int trackCount) {
		super();
		this.albumId = albumId;
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.label = label;
		this.trackCount = trackCount;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", title=" + title + ", artist=" + artist + ", genre=" + genre + ", label="
				+ label + ", trackCount=" + trackCount + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return albumId == other.albumId && Objects.equals(artist, other.artist) && Objects.equals(genre, other.genre)
				&& Objects.equals(label, other.label) && Objects.equals(title, other.title)
				&& trackCount == other.trackCount;
	}

}
