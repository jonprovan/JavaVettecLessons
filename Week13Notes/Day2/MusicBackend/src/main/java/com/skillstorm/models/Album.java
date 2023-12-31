package com.skillstorm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// looks just like a regular class at first
// we must map all properties to their database equivalents

// this annotation designates that this class is mapping to a table (specifically a single record) in our database
@Entity
// this specifies which table in our database goes with this entity
@Table(name = "album")
public class Album {
	
	// this specifies this as the primary key
	@Id
	// this specifies that the value for this property is auto-generated and how
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "album_id")
	private int albumId;
	
	// this annotation specifies which column in the table this property goes with
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
	
}
