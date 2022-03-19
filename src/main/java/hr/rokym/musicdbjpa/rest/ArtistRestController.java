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

import hr.rokym.musicdbjpa.entity.Artist;
import hr.rokym.musicdbjpa.entity.ArtistDetail;
import hr.rokym.musicdbjpa.service.ArtistDetailService;
import hr.rokym.musicdbjpa.service.ArtistService;

@RestController
@RequestMapping("/api")
public class ArtistRestController {

	private ArtistService artistService;
	
	private ArtistDetailService artistDetailService;
	
	@Autowired
	public ArtistRestController(ArtistService artistService, ArtistDetailService artistDetailService) {
		this.artistService = artistService;
		this.artistDetailService = artistDetailService;
	}
	
	@GetMapping("/artists")
	public List<Artist> findAll() {
		return artistService.findAll();
	}
	
	@GetMapping("/artists/{artistId}")
	public Artist getArtist(@PathVariable int artistId) {
		
		Artist theArtist = artistService.findById(artistId);
		
		if (theArtist == null) {
			throw new RuntimeException("Artist not found - " + artistId);
		}
		
		return theArtist;
	}
	
	@PostMapping("/artists/{detailId}")
	public Artist addArtist(@PathVariable int detailId, @RequestBody Artist theArtist) {
		
		ArtistDetail detail = artistDetailService.findById(detailId);
		
		if(detail == null) {
			throw new RuntimeException("Detail not found!");
		}
		
		theArtist.setId(0);
		
		theArtist.setArtistDetail(detail);
		
		artistService.save(theArtist);
		
		return theArtist;
	}
	
	@PutMapping("/artists")
	public Artist updateArtist(@RequestBody Artist theArtist) {
		
		artistService.save(theArtist);
		
		return theArtist;
	}
	
	@DeleteMapping("/artists/{artistId}")
	public String deleteArtist(@PathVariable int artistId) {
		
		
		Artist tempArtist = artistService.findById(artistId);
		
		if (tempArtist == null) {
			throw new RuntimeException("Artist id not found");
		}
		
		artistService.deleteById(artistId);
		
		return "Deleted artist " + tempArtist.getName();
	}
}























