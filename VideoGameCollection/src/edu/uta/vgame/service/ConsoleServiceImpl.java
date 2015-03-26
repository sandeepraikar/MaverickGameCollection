package edu.uta.vgame.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.ConsoleDao;
import edu.uta.vgame.model.VideoGameConsole;

@Service
public class ConsoleServiceImpl implements ConsoleService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(ConsoleServiceImpl.class);

	@Autowired
	private ConsoleDao consoleDao;

	@Transactional
	public List<VideoGameConsole> getAllConsoles() {
		LOGGER.info("calling getAllConsoles method from service.... ");
		return consoleDao.getAllConsoles();
	}

	@Transactional
	public VideoGameConsole getConsole(String consoleId) {
		LOGGER.info("calling getConsole method from service.... ");
		return consoleDao.getConsole(consoleId);
	}

	@Transactional
	public List<String> getMappedConsoles(String videoGameId) {
		LOGGER.info("Retrieving the list of mapped Consoles for the VideoGameId : "+videoGameId);
		return consoleDao.getMappedConsoles(videoGameId);
	}

}
