package edu.uta.vgame.service;

import java.math.BigDecimal;
import java.util.List;

import edu.uta.vgame.model.VideoGameCollection;

public interface CollectionService {
	
	public List<VideoGameCollection> getAllCollection();

	public VideoGameCollection getCollection(String collectionId);

	public BigDecimal getMappedMarketValue(String videoGameId, String consoleId,String contentId);
	
	public void addToGameCollection(VideoGameCollection videoGameCollection);
	
	public int checkIfGameExists(String videoGameId, String consoleId, String contentId, String conditionId);
	
	public List<Object[]> searchGameCollection(VideoGameCollection videoGameCollection);
	
	public VideoGameCollection getPersistedRecord(String videoGameId,String consoleId,String contentId, String conditionId);
	
	public List<Object[]> query1();
	
	public List<Object[]> query2();
	
	public Double query3();
	
	public List<Object[]> query4();
	
	public List<Object[]> query5();
	
	public List<Object[]> query6();
	
	public List<Object[]> query7();

}
