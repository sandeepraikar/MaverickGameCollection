package edu.uta.vgame.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.ContentDao;
import edu.uta.vgame.model.VideoGameContent;

@Service
public class ContentServiceImpl implements ContentService{

	private static Logger LOGGER = LoggerFactory
			.getLogger(ContentServiceImpl.class);

	@Autowired
	private ContentDao contentDao;
	
	@Transactional
	public List<VideoGameContent> getAllContents() {
		LOGGER.info("calling getAllContents method from service.... ");
		return contentDao.getAllContents();
	}

	@Transactional
	public VideoGameContent getContent(String contentId) {
		LOGGER.info("calling getContent method from service.... ");
		return contentDao.getContent(contentId);
	}

}
