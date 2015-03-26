package edu.uta.vgame.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.uta.vgame.model.VideoGameConsole;

@Repository
public class ConsoleDaoImpl implements ConsoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOGGER = LoggerFactory
			.getLogger(ConsoleDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameConsole> getAllConsoles() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGame consoles from ConsoleDaoImpl....");
			return session.createQuery("from VideoGameConsole").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@Override
	public VideoGameConsole getConsole(String consoleId) {
		return (VideoGameConsole) sessionFactory.getCurrentSession().get(
				VideoGameConsole.class, consoleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMappedConsoles(String videoGameId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sqlQuery = "select distinct r.console_id from released r where videogame_id='"
					+ videoGameId + "'";
			return session.createSQLQuery(sqlQuery).list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}

		finally {
			session.close();
		}

	}

}
