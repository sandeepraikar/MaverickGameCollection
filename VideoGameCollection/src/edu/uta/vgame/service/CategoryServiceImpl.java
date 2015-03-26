package edu.uta.vgame.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uta.vgame.dao.CategoryDao;
import edu.uta.vgame.model.VideoGameCategory;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;

	private static Logger LOGGER = LoggerFactory
			.getLogger(CategoryServiceImpl.class);
	
	@Transactional
	public List<VideoGameCategory> getAllCategories() {
		LOGGER.info("calling getAllCategories method from service.... ");
		return categoryDao.getAllCategories();
	}

	@Transactional
	public VideoGameCategory getCategory(String categoryId) {
		LOGGER.info("calling getCategory method from service.... ");
		return categoryDao.getCategory(categoryId);
	}

}
