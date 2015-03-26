package edu.uta.vgame.service;

import java.util.List;

import edu.uta.vgame.model.VideoGameMaster;

public interface VideoGameService {

	public List<VideoGameMaster> getAllVideoGames();

	public VideoGameMaster getVideoGame(String videoGameId);

}
