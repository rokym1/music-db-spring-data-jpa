DROP SCHEMA IF EXISTS `music-db`;

CREATE SCHEMA `music-db`;

use `music-db`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `artist_detail`;

CREATE TABLE `artist_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web_page` varchar(128) DEFAULT NULL,
  `facebook` varchar(128) DEFAULT NULL,
  `instagram` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `artist`;

CREATE TABLE `artist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `artist_detail_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  UNIQUE KEY `NAME_UNIQUE` (`name`),

  KEY `FK_DETAIL_idx` (`artist_detail_id`),
  CONSTRAINT `FK_DETAIL` 
  FOREIGN KEY (`artist_detail_id`) 
  REFERENCES `artist_detail` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `artist_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_ARTIST_idx` (`artist_id`),
  
  CONSTRAINT `FK_ARTIST` 
  FOREIGN KEY (`artist_id`) 
  REFERENCES `artist` (`id`) 
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `artist_id` int(11) DEFAULT NULL,
  `album_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  
  KEY `FK_ARTIST_idx` (`artist_id`),
  
  CONSTRAINT `FK_ARTIST_2` 
  FOREIGN KEY (`artist_id`) 
  REFERENCES `artist` (`id`)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_ALBUM`
  FOREIGN KEY (`album_id`)
  REFERENCES `album` (`id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `genre`;

CREATE TABLE `genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `artist_genre`;

CREATE TABLE `artist_genre` (
  `artist_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL,
  
  PRIMARY KEY (`artist_id`,`genre_id`),
  
  KEY `FK_ARTIST_idx` (`artist_id`),
  
  CONSTRAINT `FK_GENRE` FOREIGN KEY (`genre_id`) 
  REFERENCES `genre` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ARTIST_3` FOREIGN KEY (`artist_id`) 
  REFERENCES `artist` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
