package hr.rokym.musicdbjpa.service;

import java.util.List;

import hr.rokym.musicdbjpa.entity.Song;

public interface SongService {
	
	public List<Song> findAll();
	
	public Song findById(int id);
	
	public void save(Song song);
	
	public void deleteById(int id);
}


