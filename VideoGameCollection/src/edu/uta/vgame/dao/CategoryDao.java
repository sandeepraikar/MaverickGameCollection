package edu.uta.vgame.dao;

import java.util.List;

import edu.uta.vgame.model.VideoGameCategory;

public interface CategoryDao {

	public List<VideoGameCategory> getAllCategories();

	public VideoGameCategory getCategory(String categoryId);
}
