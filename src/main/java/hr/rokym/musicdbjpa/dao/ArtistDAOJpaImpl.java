package hr.rokym.musicdbjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.musicdbjpa.entity.Artist;

@Repository
public class ArtistDAOJpaImpl implements ArtistDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ArtistDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Artist> findAll() {
	Query query = entityManager.createQuery("from Artist");
	
	
	@SuppressWarnings("unchecked")
	List<Artist> artists = query.getResultList();
		
		return artists;
	}

	@Override
	public Artist findById(int theId) {
		Artist artist = entityManager.find(Artist.class, theId);
		return artist;
	}

	@Override
	public void save(Artist theArtist) {
		
		Artist dbArtist = entityManager.merge(theArtist);
		
		theArtist.setId(dbArtist.getId());
		
	}

	@Override
	public void deleteById(int theId) {
		
		Query query = entityManager.createQuery("delete from Artist where id=:artistId");
		
		query.setParameter("artistId", theId);
	}

	
}
























