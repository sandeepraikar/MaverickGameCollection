package edu.uta.vgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEOGAME_CATEGORY")
public class VideoGameCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CATEGORY_ID")
	private String categoryId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public VideoGameCategory(String categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

}
