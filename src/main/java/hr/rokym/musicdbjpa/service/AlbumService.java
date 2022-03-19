package hr.rokym.musicdbjpa.service;

import java.util.List;

import hr.rokym.musicdbjpa.entity.Album;

public interface AlbumService {

	public List<Album> findAll();
	
	public Album findById(int theId);
	
	public void save(Album album);
	
	public void deleteById(int theId);
}

