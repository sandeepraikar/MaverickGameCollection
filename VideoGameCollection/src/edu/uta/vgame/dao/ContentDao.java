package edu.uta.vgame.dao;

import java.util.List;

import edu.uta.vgame.model.VideoGameContent;

public interface ContentDao {

	public List<VideoGameContent> getAllContents();

	public VideoGameContent getContent(String contentId);

}
