CREATE SCHEMA `musicplus`;

CREATE TABLE `musicplus`.`artist` (
  `artist_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  `founded` INT NOT NULL,
  PRIMARY KEY (`artist_id`));
  
CREATE TABLE `musicplus`.`album` (
  `album_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(60) NOT NULL,
  `artist_id` INT NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `label` VARCHAR(45) NOT NULL,
  `track_count` INT NOT NULL,
  `image_url` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`album_id`),
  INDEX `artist_id_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `artist_id`
    FOREIGN KEY (`artist_id`)
    REFERENCES `musicplus`.`artist` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO artist(name, type, founded) VALUES('Toto', 'Quartet', 1979);
INSERT INTO artist(name, type, founded) VALUES('Banda MS', 'Nineteensome', 2003);
INSERT INTO artist(name, type, founded) VALUES('Led Zeppelin', 'Quartet', 1968);
INSERT INTO artist(name, type, founded) VALUES('Soda Stereo', 'Trio', 1982);

INSERT INTO album(title, artist_id, genre, label, track_count, image_url) VALUES ('Toto', 1, 'Prog Rock', 'Columbia', 10, 'https://m.media-amazon.com/images/I/71U4Ak9MquL._SX522_.jpg');
INSERT INTO album(title, artist_id, genre, label, track_count, image_url) VALUES ('La Mejor Version de Mi', 2, 'Banda', 'Lizos Music', 19, 'https://m.media-amazon.com/images/I/61vooU2VpmL._UX500_FMwebp_QL85_.jpg');
INSERT INTO album(title, artist_id, genre, label, track_count, image_url) VALUES ('Mothership', 3, 'Classic Rock', 'Atlantic Records', 24, 'https://m.media-amazon.com/images/I/91T2ml6rovL._SX522_.jpg');
INSERT INTO album(title, artist_id, genre, label, track_count, image_url) VALUES ('Cancion Animal', 4, 'Alternative Rock', 'Sony Music', 10, 'https://m.media-amazon.com/images/I/51rMXhdKw1L.jpg');

select * from album;
select * from artist;