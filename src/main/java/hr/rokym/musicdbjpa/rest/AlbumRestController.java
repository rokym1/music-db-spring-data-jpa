package hr.rokym.musicdbjpa.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.rokym.musicdbjpa.entity.Album;
import hr.rokym.musicdbjpa.entity.Artist;
import hr.rokym.musicdbjpa.service.AlbumService;
import hr.rokym.musicdbjpa.service.ArtistService;

@RestController
@RequestMapping("/api")
public class AlbumRestController {

	private AlbumService albumService;
	
	private ArtistService artistService;
	
	@Autowired
	public AlbumRestController(AlbumService albumService, ArtistService artistService) {
		this.albumService = albumService;
		this.artistService = artistService;
	}
	
	@GetMapping("/albums")
	public List<Album> findAll() {
		return albumService.findAll();
	}
	
	@GetMapping("/albums/{id}")
	public Album getAlbum(@PathVariable int id) {
		Album album = albumService.findById(id);
		
		if(album == null) {
			throw new RuntimeException("Album not found");
		}
		
		return album;
	}
	
	@PostMapping("/albums/{artistId}")
	public Album addAlbum(@PathVariable int artistId, @RequestBody Album album) {
		
		Artist artist = artistService.findById(artistId);
		
		if(artist == null) {
			throw new RuntimeException("Artist id not found");
		}
		
		album.setId(0);
		
		album.setArtist(artist);
		
		albumService.save(album);
		
		return album;
	}
	
	@PutMapping("/albums")
	public Album updateAlbum(@RequestBody Album album) {
		
		albumService.save(album);
		
		return album;
	}
	
	@DeleteMapping("/albums/{theId}")
	public String deleteAlbum(@PathVariable int theId) {
		
		Album album = albumService.findById(theId);
		
		if (album == null) {
			throw new RuntimeException("Album id not found");
		}
		
		albumService.deleteById(theId);
		
		return "Deleted album " + album.getTitle();
	}
}























