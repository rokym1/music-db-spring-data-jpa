package hr.rokym.musicdbjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.rokym.musicdbjpa.dao.ArtistDAO;
import hr.rokym.musicdbjpa.entity.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	private ArtistDAO artistDAO;
	
	@Autowired
	public ArtistServiceImpl(ArtistDAO theArtistDAO) {
		artistDAO = theArtistDAO;
	}

	@Override
	@Transactional
	public List<Artist> findAll() {
		
		return artistDAO.findAll();
	}

	@Override
	@Transactional
	public Artist findById(int theId) {
		
		return artistDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Artist theArtist) {
		
		artistDAO.save(theArtist);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		artistDAO.deleteById(theId);
	}

}
