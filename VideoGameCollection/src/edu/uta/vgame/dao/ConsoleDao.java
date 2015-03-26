package edu.uta.vgame.dao;

import java.util.List;

import edu.uta.vgame.model.VideoGameConsole;

public interface ConsoleDao {

	public List<VideoGameConsole> getAllConsoles();

	public VideoGameConsole getConsole(String consoleId);
	
	public List<String> getMappedConsoles(String videoGameId);
}
