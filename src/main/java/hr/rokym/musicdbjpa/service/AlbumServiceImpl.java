package hr.rokym.musicdbjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.rokym.musicdbjpa.dao.AlbumRepository;
import hr.rokym.musicdbjpa.entity.Album;

@Service
public class AlbumServiceImpl implements AlbumService {
	
	private AlbumRepository albumRepository;
	
	@Autowired
	public AlbumServiceImpl(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}

	@Override
	public List<Album> findAll() {
		
		return albumRepository.findAll();
	}

	@Override
	public Album findById(int theId) {
		
		Optional<Album> result = albumRepository.findById(theId);
		
		Album album = null;
		
		if (result.isPresent()) {
			album = result.get();
		}
		else {
			throw new RuntimeException("Did not found album id");
		}
		
		return album;
	}

	@Override
	public void save(Album album) {
		
		albumRepository.save(album);
	}

	@Override
	public void deleteById(int theId) {
		
		albumRepository.deleteById(theId);
	}
}


