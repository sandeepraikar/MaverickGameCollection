package edu.uta.vgame.service;

import java.util.List;

import edu.uta.vgame.model.VideoGameCondition;

public interface ConditionService {

	public List<VideoGameCondition> getAllConditions();

	public VideoGameCondition getCondition(String conditionId);

}
