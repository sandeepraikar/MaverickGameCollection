package edu.uta.vgame.service;

import java.util.List;

import edu.uta.vgame.model.VideoGameConsole;

public interface ConsoleService {
	public List<VideoGameConsole> getAllConsoles();

	public VideoGameConsole getConsole(String consoleId);
	
	public List<String> getMappedConsoles(String videoGameId);
}
