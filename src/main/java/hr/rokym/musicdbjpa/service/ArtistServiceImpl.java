package hr.rokym.musicdbjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.rokym.musicdbjpa.dao.ArtistRepository;
import hr.rokym.musicdbjpa.entity.Artist;

@Service
public class ArtistServiceImpl implements ArtistService {
	
	private ArtistRepository artistRepository;
	
	@Autowired
	public ArtistServiceImpl(ArtistRepository artistRepository) {
		this.artistRepository = artistRepository;
	}

	@Override
	public List<Artist> findAll() {
		
		return artistRepository.findAll();
	}

	@Override
	public Artist findById(int theId) {
		
		Optional<Artist> result = artistRepository.findById(theId);
		
		Artist artist = null;
		
		if (result.isPresent()) {
			artist = result.get();
		}
		else {
			throw new RuntimeException("Did not found artist id");
		}
		
		return artist;
	}
	
	@Override
	public void save(Artist theArtist) {
		
		artistRepository.save(theArtist);
	}

	@Override
	public void deleteById(int theId) {
		
		artistRepository.deleteById(theId);
	}
}


