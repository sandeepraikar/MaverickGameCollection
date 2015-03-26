package edu.uta.vgame.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.uta.vgame.util.*;
import edu.uta.vgame.model.VideoGameCollection;

@Repository
public class CollectionDaoImpl implements CollectionDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CollectionDaoImpl.class);
	static boolean i;
	@SuppressWarnings("unchecked")
	@Override
	public List<VideoGameCollection> getAllCollection() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Returning list of all VideoGames collections from CollectionDaoImpl....");
			return session.createQuery("from VideoGameCollection").list();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@Override
	public VideoGameCollection getCollection(String collectionId) {

		return (VideoGameCollection) sessionFactory.getCurrentSession().get(
				VideoGameCollection.class, collectionId);

	}

	@Override
	public BigDecimal getMappedMarketValue(String videoGameId,
			String consoleId, String contentId) {
		Session session = null;
		BigDecimal queryResult = null;
		BigDecimal defaultValue = new BigDecimal("0");
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			String sqlQuery = "select r.market_price from released r where r.videogame_id='"
					+ videoGameId
					+ "' and r.console_id='"
					+ consoleId
					+ "' and r.content_id='" + contentId + "'";
			Query query = session.createSQLQuery(sqlQuery);
			queryResult = (BigDecimal) query.uniqueResult();
			LOGGER.info("Market value returned from DB : " + queryResult);
			if (queryResult != null)
				return queryResult;
			else
				return defaultValue;

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
	public void addToGameCollection(VideoGameCollection videoGameCollection) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();

			session.save(videoGameCollection);
			trans.commit();

		} catch (PersistenceException ex) {
			trans.rollback();
			throw ex;
		} catch (Exception ex) {
			trans.rollback();
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@Override
	public int checkIfGameExists(String videoGameId, String consoleId,
			String contentId, String conditionId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query query = session
					.createSQLQuery("select vcd.collection_id from videogame_collection_details vcd where vcd.videogame_id='"
							+ videoGameId
							+ "' and vcd.console_id='"
							+ consoleId
							+ "' and vcd.content_id='"
							+ contentId
							+ "' and vcd.condition_id='"
							+ conditionId
							+ "'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				return (int) query.uniqueResult();
			}
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			/* Close session to return DB Connection to pool */
			session.close();

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> searchGameCollection(
			VideoGameCollection videoGameCollection) {
		Session session = null;
		
		try {

			String sqlQuery = "";
			sqlQuery = createDynamicQuery(videoGameCollection);
			LOGGER.info("After calling createDynamicQuery : " + sqlQuery);
			if (!(sqlQuery.isEmpty())) {
				sqlQuery = "select VCD.COLLECTION_ID, VM.VIDEOGAME_TITLE, VCN.CONSOLE_NAME, VCT.CONTENT_TYPE, VC.CONDITION_TYPE,VCD.PURCHASE_DATE,R.MARKET_PRICE,VCD.PURCHASE_PRICE  from VIDEOGAME_COLLECTION_DETAILS VCD , VIDEOGAME_MASTER_DETAILS VM, VIDEOGAME_CONDITION VC, VIDEOGAME_CONTENT VCT, VIDEOGAME_CONSOLE VCN, RELEASED R  where VCD.VIDEOGAME_ID=VM.VIDEOGAME_ID and VCD.CONSOLE_ID=VCN.CONSOLE_ID and VCD.CONTENT_ID=VCT.CONTENT_ID and VCD.CONDITION_ID=VC.CONDITION_ID and VCD.VIDEOGAME_ID=R.VIDEOGAME_ID and VCD.CONSOLE_ID=R.CONSOLE_ID and VCD.CONTENT_ID=R.CONTENT_ID and"+ sqlQuery;
			} else {
				sqlQuery = "select VCD.COLLECTION_ID, VM.VIDEOGAME_TITLE, VCN.CONSOLE_NAME, VCT.CONTENT_TYPE, VC.CONDITION_TYPE,VCD.PURCHASE_DATE,R.MARKET_PRICE,VCD.PURCHASE_PRICE  from VIDEOGAME_COLLECTION_DETAILS VCD , VIDEOGAME_MASTER_DETAILS VM, VIDEOGAME_CONDITION VC, VIDEOGAME_CONTENT VCT, VIDEOGAME_CONSOLE VCN, RELEASED R where VCD.VIDEOGAME_ID=VM.VIDEOGAME_ID and VCD.CONSOLE_ID=VCN.CONSOLE_ID and VCD.CONTENT_ID=VCT.CONTENT_ID and VCD.CONDITION_ID=VC.CONDITION_ID and VCD.VIDEOGAME_ID=R.VIDEOGAME_ID and VCD.CONSOLE_ID=R.CONSOLE_ID and VCD.CONTENT_ID=R.CONTENT_ID";
			}

			session = sessionFactory.openSession();
			LOGGER.info("Before executing sqlQuery : " + sqlQuery);
			Query query = session.createSQLQuery(sqlQuery);
			return query.list();
			 
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {

			throw new PersistenceException(ex);
		} finally {
			session.close();

		}
	}
	
	public String createDynamicQuery(VideoGameCollection filterCriteria) {
		String sqlQuery = "";
		i = false;

		LOGGER.info("Inside createDynamic query..!!!");
	
		LOGGER.info("Check for videoGame drop down ");
		if (CommonUtil.stringEmptyCheck(filterCriteria.getVideoGameId()) == false) {
			if (i == true) {
				sqlQuery += " and ";
			}
			sqlQuery += " VCD.VIDEOGAME_ID='"
					+ filterCriteria.getVideoGameId() + "'";
			i = true;
		}
		LOGGER.info("Check for game console drop down ");
		if (CommonUtil.stringEmptyCheck(filterCriteria.getConsoleId()) == false) {
			if (i == true) {
				sqlQuery += " and ";
			}
			sqlQuery += " VCD.CONSOLE_ID='"
					+ filterCriteria.getConsoleId() + "'";
			i = true;
		}
		LOGGER.info("Check for game condition drop down ");
		if (CommonUtil.stringEmptyCheck(filterCriteria.getConditionId()) == false) {
			if (i == true) {
				sqlQuery += " and ";
			}
			sqlQuery += " VCD.CONDITION_ID='"
					+ filterCriteria.getConditionId() + "'";
			i = true;
		}
		LOGGER.info("Check for game contents drop down ");
		if (CommonUtil.stringEmptyCheck(filterCriteria.getContentId()) == false) {
			if (i == true) {
				sqlQuery += " and ";
			}
			sqlQuery += " VCD.CONTENT_ID='"
					+ filterCriteria.getContentId() + "'";
			i = true;
		}
		
		LOGGER.info("final query string formed : " + sqlQuery);
		return sqlQuery;

	}

	@Override
	public VideoGameCollection getPersistedRecord(String videoGameId,String consoleId,
			String contentId, String conditionId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			LOGGER.info("Get the Persisted Collection object based on consoleId, conditionId, contentId from CollectionDaoImpl....");
			return (VideoGameCollection)session.createQuery("from VideoGameCollection where VIDEOGAME_ID='"+videoGameId+"' and CONSOLE_ID='"+consoleId+"' and CONTENT_ID='"+contentId+"' and CONDITION_ID='"+conditionId+"'").uniqueResult();

		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query1() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vm.videogame_title, vc.console_name from  videogame_collection_details vcd, videogame_master_details vm, videogame_console vc where	vm.videogame_id=vcd.videogame_id and vc.console_id=vcd.console_id and  vcd.videogame_id IN (select  videogame_id   from videogame_console_map  group by videogame_id   having count(*) = 1)");
			Query query = session.createSQLQuery(Constants.QUERY1);
			
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			/* Close session to return DB Connection to pool */
			session.close();

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query2() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vm.videogame_title, count(*) as number_of_occurances from  videogame_master_details vm, videogame_collection_details vc where 	vm.videogame_id=vc.videogame_id group by vc.videogame_id having count(*)>1");
			Query query = session.createSQLQuery(Constants.QUERY2);
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			/* Close session to return DB Connection to pool */
			session.close();
		}
	}

	@Override
	public Double query3() {
		Session session = null;
		Double queryResult = null;		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();			
			//Query query = session.createSQLQuery("select sum(purchase_price) from videogame_collection_details");
			Query query = session.createSQLQuery(Constants.QUERY3);
			queryResult = (Double) query.uniqueResult();
			LOGGER.info("Total cost of the person's collection : " + queryResult);
			return queryResult;
			
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		}

		finally {
			session.close();
		}


	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query4() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vm.videogame_title, vc.content_type, vcn.condition_type from  videogame_master_details vm, videogame_content vc, videogame_collection_details vcd,videogame_condition vcn where  vcd.content_id = vc.content_id	and vm.videogame_id = vcd.videogame_id 	and vcd.condition_id=vcn.condition_id");
			Query query = session.createSQLQuery(Constants.QUERY4);
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query5() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vmd.videogame_title, max(vcd.purchase_price) from videogame_Collection_details vcd,videogame_market_value vmv, videogame_master_details vmd where vcd.videogame_id=vmv.videogame_id and vcd.console_id=vmv.console_id and vcd.content_id=vmv.content_id and  vcd.purchase_price>vmv.market_price and vcd.videogame_id=vmd.videogame_id");
			Query query = session.createSQLQuery(Constants.QUERY5);
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query6() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vmd.videogame_title, vcd.purchase_price as PurchasePrice, vmv.market_price as MarketPrice from videogame_Collection_details vcd,videogame_market_value vmv, videogame_master_details vmd where vcd.videogame_id=vmv.videogame_id and vcd.console_id=vmv.console_id and vcd.content_id=vmv.content_id and  vcd.purchase_price<vmv.market_price and vcd.videogame_id=vmd.videogame_id");
			Query query = session.createSQLQuery(Constants.QUERY6);
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> query7() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			//Query query = session.createSQLQuery("select vmd.videogame_title, (vmv.market_price - vcd.purchase_price) as Remainder_price from videogame_Collection_details vcd,videogame_market_value vmv, videogame_master_details vmd where vcd.videogame_id=vmv.videogame_id and vcd.console_id=vmv.console_id and vcd.content_id=vmv.content_id and vcd.purchase_price<vmv.market_price and vcd.videogame_id=vmd.videogame_id");
			Query query = session.createSQLQuery(Constants.QUERY7);
			return query.list();
		} catch (PersistenceException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new PersistenceException(ex);
		} finally {
			session.close();
		}	}
}
