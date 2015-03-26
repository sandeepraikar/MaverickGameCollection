package edu.uta.vgame.service;

import java.util.List;

import edu.uta.vgame.model.VideoGameCategory;

public interface CategoryService {
	
	public List<VideoGameCategory> getAllCategories();

	public VideoGameCategory getCategory(String categoryId);


}
