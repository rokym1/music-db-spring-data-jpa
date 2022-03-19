package hr.rokym.musicdbjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.rokym.musicdbjpa.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {

}
