package hr.rokym.musicdbjpa.service;

import java.util.List;

import hr.rokym.musicdbjpa.entity.Artist;

public interface ArtistService {

	public List<Artist> findAll();
	
	public Artist findById(int theId);
	
	public void save(Artist theArtist);
	
	public void deleteById(int theId);
}
