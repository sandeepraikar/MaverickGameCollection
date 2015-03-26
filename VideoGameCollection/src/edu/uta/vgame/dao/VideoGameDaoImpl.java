package edu.uta.vgame.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uta.vgame.model.VideoGameMaster;

@Repository
public class VideoGameDaoImpl implements VideoGameDao {

	private static Logger LOGGER = LoggerFactory
			.getLogger(VideoGameDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameMaster> getAllVideoGames() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGames  from VideoGameDaoImpl....");

			return session.createQuery("from VideoGameMaster").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@Override
	public VideoGameMaster getVideoGame(String videoGameId) {
		return (VideoGameMaster) sessionFactory.getCurrentSession().get(
				VideoGameMaster.class, videoGameId);
	}

}
