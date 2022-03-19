package hr.rokym.musicdbjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.musicdbjpa.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

}

