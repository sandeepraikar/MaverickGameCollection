package edu.uta.vgame.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.CollectionDao;
import edu.uta.vgame.model.VideoGameCollection;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	private CollectionDao collectionDao;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CollectionServiceImpl.class);

	@Transactional
	public List<VideoGameCollection> getAllCollection() {
		LOGGER.info("calling getAllCollections method from service.... ");
		return collectionDao.getAllCollection();
	}

	@Transactional
	public VideoGameCollection getCollection(String collectionId) {
		LOGGER.info("calling getCollection method from service.... ");
		return collectionDao.getCollection(collectionId);
	}

	@Transactional
	public BigDecimal getMappedMarketValue(String videoGameId,
			String consoleId, String contentId) {
		return collectionDao.getMappedMarketValue(videoGameId, consoleId, contentId);
	}

	@Transactional
	public void addToGameCollection(VideoGameCollection videoGameCollection) {
		LOGGER.info("calling addToGameCollection method from service.... ");
		collectionDao.addToGameCollection(videoGameCollection);
	}

	@Transactional
	public int checkIfGameExists(String videoGameId, String consoleId,
			String contentId,String conditionId) {
		LOGGER.info("calling checkIfGameExists method from service.... ");
		return collectionDao.checkIfGameExists(videoGameId, consoleId, contentId,conditionId);
	}

	@Transactional
	public List<Object[]> searchGameCollection(
			VideoGameCollection videoGameCollection) {
		LOGGER.info("calling searchGameCollection method from service.... ");
		return collectionDao.searchGameCollection(videoGameCollection);
	}

	@Transactional
	public VideoGameCollection getPersistedRecord(String videoGameId,String consoleId,
			String contentId, String conditionId) {
		LOGGER.info("calling getPersistedRecord method from service.... ");
		return collectionDao.getPersistedRecord(videoGameId,consoleId, contentId, conditionId);
	}

	@Transactional
	public List<Object[]> query1() {
		LOGGER.info("calling query1 method from service.... ");
		return collectionDao.query1();
	}

	@Transactional
	public List<Object[]> query2() {
		LOGGER.info("calling query2 method from service.... ");
		return collectionDao.query2();
	}

	@Transactional
	public Double query3() {
		LOGGER.info("calling query3 method from service.... ");
		return collectionDao.query3();
	}

	@Transactional
	public List<Object[]> query4() {
		LOGGER.info("calling query4 method from service.... ");
		return collectionDao.query4();
	}

	@Transactional
	public List<Object[]> query5() {
		LOGGER.info("calling query5 method from service.... ");
		return collectionDao.query5();
	}

	@Transactional
	public List<Object[]> query6() {
		LOGGER.info("calling query6 method from service.... ");
		return collectionDao.query6();
	}

	@Transactional
	public List<Object[]> query7() {
		LOGGER.info("calling query7 method from service.... ");
		return collectionDao.query7();	}

}
