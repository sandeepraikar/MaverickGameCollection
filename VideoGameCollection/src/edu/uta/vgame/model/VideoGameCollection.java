package edu.uta.vgame.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEOGAME_COLLECTION_DETAILS")
public class VideoGameCollection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COLLECTION_ID")
	private BigDecimal collectionId;

	@Column(name = "VIDEOGAME_ID")
	private String videoGameId;

	@Column(name = "CONSOLE_ID")
	private String consoleId;

	@Column(name = "CONTENT_ID")
	private String contentId;

	@Column(name = "CONDITION_ID")
	private String conditionId;

	@Column(name = "PURCHASE_DATE")
	private Date purchaseDate;

	@Column(name = "PURCHASE_PRICE")
	private BigDecimal purchasePrice;

	public BigDecimal getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(BigDecimal collectionId) {
		this.collectionId = collectionId;
	}

	public String getConsoleId() {
		return consoleId;
	}

	public void setConsoleId(String consoleId) {
		this.consoleId = consoleId;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getConditionId() {
		return conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getVideoGameId() {
		return videoGameId;
	}

	public void setVideoGameId(String videoGameId) {
		this.videoGameId = videoGameId;
	}

	public VideoGameCollection() {
	}

	public VideoGameCollection(BigDecimal collectionId, String videoGameId,
			String consoleId, String contentId, String conditionId,
			Date purchaseDate, BigDecimal purchasePrice) {
		super();
		this.collectionId = collectionId;
		this.videoGameId = videoGameId;
		this.consoleId = consoleId;
		this.contentId = contentId;
		this.conditionId = conditionId;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
	}


}
