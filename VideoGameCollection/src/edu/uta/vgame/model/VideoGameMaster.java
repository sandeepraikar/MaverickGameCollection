package edu.uta.vgame.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIDEOGAME_MASTER_DETAILS")
public class VideoGameMaster implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VIDEOGAME_ID")
	private BigDecimal videoGameId;
	
	@Column(name="VIDEOGAME_TITLE")
	private String videoGameTitle;
	
	@Column(name="MULTIPLAYER_OPTION")
	private boolean multiPlayerOption;
	
	@Column(name="CATEGORY_ID")
	private String categoryId;	
	/**
	 * @return the videoGameId
	 */
	public BigDecimal getVideoGameId() {
		return videoGameId;
	}

	/**
	 * @param videoGameId the videoGameId to set
	 */
	public void setVideoGameId(BigDecimal videoGameId) {
		this.videoGameId = videoGameId;
	}

	/**
	 * @return the videoGameTitle
	 */
	public String getVideoGameTitle() {
		return videoGameTitle;
	}

	/**
	 * @param videoGameTitle the videoGameTitle to set
	 */
	public void setVideoGameTitle(String videoGameTitle) {
		this.videoGameTitle = videoGameTitle;
	}

	/**
	 * @return the multiPlayerOption
	 */
	public boolean isMultiPlayerOption() {
		return multiPlayerOption;
	}

	/**
	 * @param multiPlayerOption the multiPlayerOption to set
	 */
	public void setMultiPlayerOption(boolean multiPlayerOption) {
		this.multiPlayerOption = multiPlayerOption;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public VideoGameMaster(){}
	
	public VideoGameMaster(BigDecimal videoGameId, String videoGameTitle,
			boolean multiPlayerOption, String categoryId) {
		super();
		this.videoGameId = videoGameId;
		this.videoGameTitle = videoGameTitle;
		this.multiPlayerOption = multiPlayerOption;
		this.categoryId = categoryId;
	}
	
	
}
