package hr.rokym.musicdbjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.musicdbjpa.entity.ArtistDetail;

@Repository
public class ArtistDetailDAOJpaImpl implements ArtistDetailDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public ArtistDetailDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<ArtistDetail> findAll() {
		
		Query query = entityManager.createQuery("from ArtistDetail");
		
		@SuppressWarnings("unchecked")
		List<ArtistDetail> details = query.getResultList();
		
		return details;
	}
	
	@Override
	public ArtistDetail findById(int theId) {
		
		ArtistDetail detail = entityManager.find(ArtistDetail.class, theId);
		
		return detail;
		
	}
	@Override
	public void save(ArtistDetail theArtistDetail) {

		ArtistDetail dbDetail = entityManager.merge(theArtistDetail);
		
		theArtistDetail.setId(dbDetail.getId()); 
		
	}

	@Override
	public void deleteById(int theId) {
		
		Query query = entityManager.createQuery("delete from ArtistDetail where id=:artistDetailId");
		
		query.setParameter("artistDetailId", theId);
		

	}
}






