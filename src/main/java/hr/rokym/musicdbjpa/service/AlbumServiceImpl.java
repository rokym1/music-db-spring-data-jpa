package hr.rokym.musicdbjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.rokym.musicdbjpa.dao.AlbumDAO;
import hr.rokym.musicdbjpa.entity.Album;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumDAO albumDAO;
	
	@Autowired
	public AlbumServiceImpl(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}

	@Override
	@Transactional
	public List<Album> findAll() {
		
		return albumDAO.findAll();
	}

	@Override
	@Transactional
	public Album findById(int theId) {
		
		return albumDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Album album) {
		
		albumDAO.save(album);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		albumDAO.deleteById(theId);
	}

}
