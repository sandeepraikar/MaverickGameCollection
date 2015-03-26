package edu.uta.vgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIDEOGAME_CONTENT")
public class VideoGameContent implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CONTENT_ID")
	private String contentId;
	
	@Column(name="CONTENT_TYPE")
	private String contentType;
	
	@Column(name="CONTENT_DESCRIPTION")
	private String contentDescription;

	
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(String contentDescription) {
		this.contentDescription = contentDescription;
	}

	public VideoGameContent(){}
	
	public VideoGameContent(String contentId, String contentType,
			String contentDescription) {
		super();
		this.contentId = contentId;
		this.contentType = contentType;
		this.contentDescription = contentDescription;
	}
	
	
}
