package hr.rokym.musicdbjpa.dao;

import java.util.List;

import hr.rokym.musicdbjpa.entity.Artist;

public interface ArtistDAO {

	public List<Artist> findAll();
	
	public Artist findById(int theId);
	
	public void save(Artist theArtist);
	
	public void deleteById(int theId);
}


