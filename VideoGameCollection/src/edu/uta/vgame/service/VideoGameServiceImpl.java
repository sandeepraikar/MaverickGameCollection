package edu.uta.vgame.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.VideoGameDao;
import edu.uta.vgame.model.VideoGameMaster;

@Service
public class VideoGameServiceImpl implements VideoGameService{

	private static Logger LOGGER = LoggerFactory
			.getLogger(VideoGameServiceImpl.class);

	
	@Autowired
	private VideoGameDao videoGameDao;
	
	@Transactional
	public List<VideoGameMaster> getAllVideoGames() {
		LOGGER.info("calling getAllVideoGames method from service.... ");
		return videoGameDao.getAllVideoGames();
	}

	@Transactional
	public VideoGameMaster getVideoGame(String videoGameId) {
		LOGGER.info("calling getVideoGame method from service.... ");
		return videoGameDao.getVideoGame(videoGameId);
	}

}
