package edu.uta.vgame.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uta.vgame.model.VideoGameCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CategoryDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameCategory> getAllCategories() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGame categories from CategoryDaoImpl....");
			return session.createQuery("from VideoGameCategory").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@Override
	public VideoGameCategory getCategory(String categoryId) {

		return (VideoGameCategory) sessionFactory.getCurrentSession().get(
				VideoGameCategory.class, categoryId);
	}

}
