package hr.rokym.musicdbjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hr.rokym.musicdbjpa.entity.Song;

@Repository
public class SongDAOJpaImpl implements SongDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public SongDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Song> findAll() {
		
		Query query = entityManager.createQuery("from Song");
		
		@SuppressWarnings("unchecked")
		List<Song> songs = query.getResultList();
		
		return songs;
	}

	@Override
	public Song findById(int id) {
		
		Song song = entityManager.find(Song.class, id);
		
		return song;
	}

	@Override
	public void save(Song song) {
		
		Song dbSong = entityManager.merge(song);
		
		song.setId(dbSong.getId());
	}

	@Override
	public void deleteById(int id) {
		
		Query query = entityManager.createQuery("delete from Song where id=:songId");
		
		query.setParameter("songId", id);
	}
}












