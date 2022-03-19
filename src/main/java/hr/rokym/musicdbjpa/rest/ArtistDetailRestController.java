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

import hr.rokym.musicdbjpa.entity.ArtistDetail;
import hr.rokym.musicdbjpa.service.ArtistDetailService;

@RestController
@RequestMapping("/api")
public class ArtistDetailRestController {

	private ArtistDetailService artistDetailService;
	
	@Autowired
	public ArtistDetailRestController(ArtistDetailService theArtistDetailService) {
		artistDetailService = theArtistDetailService;
	}
	
	@GetMapping("/details")
	public List<ArtistDetail> findAll() {
		return artistDetailService.findAll();
	}
	
	@GetMapping("/details/{detailId}")
	public ArtistDetail getDetail(@PathVariable int detailId) {
		
		ArtistDetail theArtistDetail = artistDetailService.findById(detailId);
		
		if (theArtistDetail == null) {
			throw new RuntimeException("Detail not found");
		}
		
		return theArtistDetail;
	}
	
	@PostMapping("/details")
	public ArtistDetail addDetail(@RequestBody ArtistDetail theDetail) {
		
		theDetail.setId(0);
		
		artistDetailService.save(theDetail);
		
		return theDetail;
	}
	
	@PutMapping("/details")
	public ArtistDetail updateDetail(@RequestBody ArtistDetail theDetail) {
		
		artistDetailService.save(theDetail);
		
		return theDetail;
	}
	
	@DeleteMapping("details/{detailId}")
	public String deleteDetail(@PathVariable int detailId) {
		
		ArtistDetail tempDetail = artistDetailService.findById(detailId);
		
		if(tempDetail == null) {
			throw new RuntimeException("Detail not found");
		}
		
		artistDetailService.deleteById(detailId);
		
		return "Deleted detail id = " + detailId;
	}
}
























