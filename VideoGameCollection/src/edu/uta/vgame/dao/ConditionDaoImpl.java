package edu.uta.vgame.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uta.vgame.model.VideoGameCondition;

@Repository
public class ConditionDaoImpl implements ConditionDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOGGER = LoggerFactory
			.getLogger(ConditionDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameCondition> getAllConditions() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGame conditions from CoditionsDaoImpl....");
			return session.createQuery("from VideoGameCondition").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}
		finally {
			session.close();
		}
	}

	@Override
	public VideoGameCondition getCondition(String conditionId) {
		return (VideoGameCondition) sessionFactory.getCurrentSession().get(
				VideoGameCondition.class, conditionId);
	}

}
