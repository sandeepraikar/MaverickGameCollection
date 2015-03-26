package edu.uta.vgame.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uta.vgame.model.VideoGameContent;

@Repository
public class ContentDaoImpl implements ContentDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOGGER = LoggerFactory
			.getLogger(ContentDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameContent> getAllContents() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGame content from ContentDaoImpl....");
			return session.createQuery("from VideoGameContent").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}

	}

	@Override
	public VideoGameContent getContent(String contentId) {
		return (VideoGameContent) sessionFactory.getCurrentSession().get(
				VideoGameContent.class, contentId);
	}

}
