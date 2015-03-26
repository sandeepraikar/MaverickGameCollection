package edu.uta.vgame.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.ConditionDao;
import edu.uta.vgame.model.VideoGameCondition;

@Service
public class ConditionServiceImpl implements ConditionService {

	private static Logger LOGGER = LoggerFactory
			.getLogger(ConditionServiceImpl.class);

	@Autowired
	private ConditionDao conditionDao;

	@Transactional
	public List<VideoGameCondition> getAllConditions() {
		LOGGER.info("calling getAllConditions method from service.... ");
		return conditionDao.getAllConditions();
	}

	@Transactional
	public VideoGameCondition getCondition(String conditionId) {
		LOGGER.info("calling getCondition method from service.... ");
		return conditionDao.getCondition(conditionId);
	}

}
