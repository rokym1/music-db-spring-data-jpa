package hr.rokym.musicdbjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.musicdbjpa.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

}

