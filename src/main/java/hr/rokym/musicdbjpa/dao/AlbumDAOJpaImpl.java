package hr.rokym.musicdbjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.musicdbjpa.entity.Album;

@Repository
public class AlbumDAOJpaImpl implements AlbumDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AlbumDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Album> findAll() {
		
		Query query = entityManager.createQuery("from Album");
		
		@SuppressWarnings("unchecked")
		List<Album> albums = query.getResultList();
		
		return albums;
	}

	@Override
	public Album findById(int theId) {
		
		Album album = entityManager.find(Album.class, theId);
		
		return album;
	}

	@Override
	public void save(Album album) {
		
		Album dbAlbum = entityManager.merge(album);
		
		album.setId(dbAlbum.getId());
	}

	@Override
	public void deleteById(int theId) {

		Query query = entityManager.createQuery("delete from Album where id=:albumId");
		
		query.setParameter("albumId", theId);
		
	}
}













