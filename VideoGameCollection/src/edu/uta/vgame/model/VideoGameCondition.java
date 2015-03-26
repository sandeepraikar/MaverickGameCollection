package edu.uta.vgame.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEOGAME_CONDITION")
public class VideoGameCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CONDITION_ID")
	private String conditionId;

	@Column(name = "CONDITION_TYPE")
	private String conditionType;

	public String getConditionId() {
		return conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	
	public VideoGameCondition(){
	}

	public VideoGameCondition(String conditionId, String conditionType) {
		this.conditionId = conditionId;
		this.conditionType = conditionType;
	}
	
}
