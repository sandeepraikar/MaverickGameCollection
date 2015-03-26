package edu.uta.vgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIDEOGAME_CONSOLE")
public class VideoGameConsole implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CONSOLE_ID")
	private String consoleId;
	
	@Column(name="CONSOLE_NAME")
	private String consoleName;
	
	
	public String getConsoleId() {
		return consoleId;
	}

	public void setConsoleId(String consoleId) {
		this.consoleId = consoleId;
	}

	public String getConsoleName() {
		return consoleName;
	}

	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}

	public VideoGameConsole(){}

	public VideoGameConsole(String consoleId, String consoleName) {
		this.consoleId = consoleId;
		this.consoleName = consoleName;
	}
	
	
}
