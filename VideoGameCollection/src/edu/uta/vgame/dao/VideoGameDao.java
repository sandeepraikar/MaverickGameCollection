package edu.uta.vgame.dao;

import java.util.List;

import edu.uta.vgame.model.VideoGameMaster;

public interface VideoGameDao {

	public List<VideoGameMaster> getAllVideoGames();

	public VideoGameMaster getVideoGame(String videoGameId);

}
