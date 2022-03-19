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
import hr.rokym.musicdbjpa.entity.Song;
import hr.rokym.musicdbjpa.service.AlbumService;
import hr.rokym.musicdbjpa.service.ArtistService;
import hr.rokym.musicdbjpa.service.SongService;

@RestController
@RequestMapping("/api")
public class SongRestController {

	private SongService songService;
	
	private ArtistService artistService;
	
	private AlbumService albumService;
	
	@Autowired
	public SongRestController(SongService songService, ArtistService artistService, 
			AlbumService albumService) {
		
		this.songService = songService;
		this.artistService = artistService;
		this.albumService = albumService;
	}
	
	@GetMapping("/songs")
	public List<Song> findAll() {
		
		return songService.findAll();
	}
	
	@GetMapping("/songs/{id}")
	public Song getSong(@PathVariable int id) {
		
		Song song = songService.findById(id);
		
		if(song == null) {
			throw new RuntimeException("Song not found");
		}
		
		return song;
	}
	
	@PostMapping("/songs/{albumId}/{artistId}")
	public Song[] addMultipleSongs(@PathVariable int albumId, @PathVariable int artistId, 
			@RequestBody Song[] songs) {
		
		Artist artist = artistService.findById(artistId);
		
		if(artist == null) {
			throw new RuntimeException("Artist not found");
		}
		
		Album album = albumService.findById(albumId);
		
		if(album == null) {
			throw new RuntimeException("Album not found");
		}
		
		for (Song tempSong : songs) {
			
			tempSong.setId(0);
			
			tempSong.setAlbum(album);
			
			tempSong.setArtist(artist);
			
			songService.save(tempSong);
		}
		
		return songs;
	}
	
	@PutMapping("/songs")
	public Song updateSong(@RequestBody Song song) {
		
		songService.save(song);
		
		return song;
	}
	
	@DeleteMapping("/songs/{id}")
	public String deleteSong(@PathVariable int id) {
		
		Song song = songService.findById(id);
		
		if (song == null) {
			throw new RuntimeException("Song not found");
		}
		
		songService.deleteById(id);
		
		return "Deleted song: " + song.getTitle();
	}
 }






















