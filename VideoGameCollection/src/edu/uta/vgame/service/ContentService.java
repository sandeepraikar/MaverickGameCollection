package edu.uta.vgame.service;

import java.util.List;

import edu.uta.vgame.model.VideoGameContent;

public interface ContentService {

	public List<VideoGameContent> getAllContents();

	public VideoGameContent getContent(String contentId);

}
