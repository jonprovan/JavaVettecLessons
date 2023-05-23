CREATE SCHEMA `music` ;

CREATE TABLE `music`.`album` (
  `album_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(60) NOT NULL,
  `artist` VARCHAR(45) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NOT NULL,
  `track_count` INT NOT NULL,
  PRIMARY KEY (`album_id`));

INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('Dark Side Of The Moon', 'Pink Floyd', 'Classic Rock', 'Capitol Records', 10);
INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('I Love You.', 'The Neighbourhood', 'Alternative', 'Columbia Records', 10);
INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('Wolf Path', 'Volfgang Twins', 'Viking Rock', 'Bandcamp', 10);
INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('Supertones Strike Back', 'The O.C. Supertones', 'Christian Ska', 'BEC', 12);
INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('Carin Leon', 'Inedit', 'Latin', 'Tamarindo Rekordsz', 17);
INSERT INTO album(title, artist, genre, label, track_count) 
	VALUES('Vikings Chant', 'Skáld', 'Viking Rock', 'DeccaBandcamp', 13);
    
SELECT * FROM album;