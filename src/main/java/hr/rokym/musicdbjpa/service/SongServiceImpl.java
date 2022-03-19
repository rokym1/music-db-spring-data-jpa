package hr.rokym.musicdbjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.rokym.musicdbjpa.dao.SongDAO;
import hr.rokym.musicdbjpa.entity.Song;

@Service
public class SongServiceImpl implements SongService {

	private SongDAO songDAO;
	
	@Autowired
	public SongServiceImpl(SongDAO songDAO) {
		this.songDAO = songDAO;
	}
	
	@Override
	@Transactional
	public List<Song> findAll() {
	
		return songDAO.findAll();
	}

	@Override
	@Transactional
	public Song findById(int id) {

		return songDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Song song) {

		songDAO.save(song);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		songDAO.deleteById(id);
	}
}



