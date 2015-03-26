package edu.uta.vgame.dao;

import java.util.List;

import edu.uta.vgame.model.VideoGameCondition;

public interface ConditionDao {
	
	public List<VideoGameCondition> getAllConditions();

	public VideoGameCondition getCondition(String conditionId);

}
