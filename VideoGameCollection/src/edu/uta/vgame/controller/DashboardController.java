package edu.uta.vgame.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.uta.vgame.model.VideoGameCollection;
import edu.uta.vgame.model.VideoGameCondition;
import edu.uta.vgame.model.VideoGameConsole;
import edu.uta.vgame.model.VideoGameContent;
import edu.uta.vgame.model.VideoGameMaster;
import edu.uta.vgame.service.CollectionService;
import edu.uta.vgame.service.ConditionService;
import edu.uta.vgame.service.ConsoleService;
import edu.uta.vgame.service.ContentService;
import edu.uta.vgame.service.VideoGameService;


/**
 * @author Sandeep
 * 
 */
@Controller
public class DashboardController {

	@Autowired
	private ConditionService conditionService;

	@Autowired
	private ConsoleService consoleService;

	@Autowired
	private VideoGameService videoGameService;

	@Autowired
	private CollectionService collectionService;

	@Autowired
	private ContentService contentService;

	private static Logger LOGGER = LoggerFactory
			.getLogger(DashboardController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String landingPage(ModelMap map) {
		map.addAttribute("VideoGameCollection", new VideoGameCollection());
		map.addAttribute("videoGameList", getListOfVideoGames());
		map.addAttribute("conditionList", getListOfGameCondition());
		map.addAttribute("consoleList", getListOfConsoles());
		map.addAttribute("contentList", getListOfGameContents());
		return "LandingPage";
	}

	@RequestMapping(value = "/searchCollection")
	public String searchCollection(ModelMap map) {
		map.addAttribute("VideoGameCollection", new VideoGameCollection());
		map.addAttribute("videoGameList", getListOfVideoGames());
		map.addAttribute("conditionList", getListOfGameCondition());
		map.addAttribute("consoleList", getListOfConsoles());
		map.addAttribute("contentList", getListOfGameContents());
		return "LandingPage";
	}

	public List<String> getListOfVideoGames() {
		List<String> videoGameList = new ArrayList<>();
		List<VideoGameMaster> listOfVideoGames = new ArrayList<>();
		listOfVideoGames = videoGameService.getAllVideoGames();
		LOGGER.info("Retrieved List of all VideoGames : "
				+ listOfVideoGames.size());
		for (VideoGameMaster videoGameMaster : listOfVideoGames) {
			videoGameList.add(videoGameMaster.getVideoGameId().toString() + "|"
					+ videoGameMaster.getVideoGameTitle());
		}
		return videoGameList;
	}

	public List<String> getListOfGameCondition() {
		List<String> conditionList = new ArrayList<>();
		List<VideoGameCondition> listOfCondition = new ArrayList<>();
		listOfCondition = conditionService.getAllConditions();
		LOGGER.info("Retrieved List of all Conditions : "
				+ listOfCondition.size());
		for (VideoGameCondition videoGameCondition : listOfCondition) {
			conditionList.add(videoGameCondition.getConditionId() + "|"
					+ videoGameCondition.getConditionType());
		}
		return conditionList;
	}

	public List<String> getListOfGameContents() {
		List<String> contentList = new ArrayList<>();
		List<VideoGameContent> listOfContents = new ArrayList<>();
		listOfContents = contentService.getAllContents();
		LOGGER.info("Retrieved List of all contents : " + listOfContents.size());
		for (VideoGameContent videoGameContent : listOfContents) {
			contentList.add(videoGameContent.getContentId() + "|"
					+ videoGameContent.getContentDescription());
		}
		return contentList;
	}

	public List<String> getListOfConsoles() {
		List<VideoGameConsole> listoOfConsoles = new ArrayList<>();
		List<String> consoleList = new ArrayList<>();
		listoOfConsoles = consoleService.getAllConsoles();

		for (VideoGameConsole videoGameConsole : listoOfConsoles) {
			consoleList.add(videoGameConsole.getConsoleId() + "|"
					+ videoGameConsole.getConsoleName());
		}
		return consoleList;
	}

	@RequestMapping(value = "/queries", method = RequestMethod.GET)
	public String queryOutput(ModelMap map) {
		

		List<Object[]> objFromDb1 = collectionService.query1();
		List<Object[]> objFromDb2 = collectionService.query2();
		Double queryResult3 = collectionService.query3();
		List<Object[]> objFromDb4 = collectionService.query4();
		List<Object[]> objFromDb5 = collectionService.query5();
		List<Object[]> objFromDb6 = collectionService.query6();
		List<Object[]> objFromDb7 = collectionService.query7();

		List<String> queryResult1 = new ArrayList<>();
		for (Object[] row : objFromDb1) {
			BigInteger temp = (BigInteger)row[0];
			queryResult1.add(temp.intValue() + "|" + (String) row[1]);
		}
		
		List<String> queryResult2 = new ArrayList<>();
		for (Object[] row : objFromDb2) {
			BigInteger temp = (BigInteger)row[1];
			queryResult2.add((String) row[0] + "|" + temp.intValue());
		}
		
		List<String> queryResult4 = new ArrayList<>();
		for (Object[] row : objFromDb4) {
			queryResult4.add((String) row[0] + "|" + (String) row[1]);
		}
		
		List<String> queryResult5 = new ArrayList<>();
		for (Object[] row : objFromDb5) {
			Double temp = (Double)row[1];
			queryResult5.add((String) row[0] + "|" + temp.intValue());
		}
		List<String> queryResult6 = new ArrayList<>();
		for (Object[] row : objFromDb6) {
			Double temp = (Double)row[2];
			queryResult6.add((String) row[0] + "|" + (BigDecimal)row[1] + "|" + temp.doubleValue());
		}
		
		List<String> queryResult7 = new ArrayList<>();
		for (Object[] row : objFromDb7) {
			Double temp = (Double)row[1];
			LOGGER.info("testing"+temp.floatValue());
			LOGGER.info("Retreived value: ",temp.intValue());
			queryResult7.add((String) row[0] + "|" + temp.floatValue());
		}
		map.addAttribute("queryResult1", queryResult1);
		map.addAttribute("queryResult2", queryResult2);
		map.addAttribute("queryResult3", queryResult3.toString());
		map.addAttribute("queryResult4", queryResult4);
		map.addAttribute("queryResult5", queryResult5);
		map.addAttribute("queryResult6", queryResult6);
		map.addAttribute("queryResult7", queryResult7);
		 if (queryResult1.isEmpty() || queryResult2.isEmpty()
		 || queryResult4.isEmpty() || queryResult5.isEmpty()
		 || queryResult6.isEmpty() || queryResult7.isEmpty()) {
		 map.addAttribute("SearchResult", "No Search Results Found");
		 }
		return "QueryOutput";
	}

	@RequestMapping(value = "/addNewGame", method = RequestMethod.GET)
	public String addNewGame(ModelMap map) {
		map.addAttribute("VideoGameCollection", new VideoGameCollection());
		map.addAttribute("videoGameList", getListOfVideoGames());
		map.addAttribute("conditionList", getListOfGameCondition());
		map.addAttribute("contentList", getListOfGameContents());
		return "AddNewGame";
	}

	@RequestMapping(value = "/getConsoleList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<String> getListOfConsoles(
			@RequestParam(value = "videoGameId") String videoGameId) {
		VideoGameConsole console = null;
		List<String> listoOfConsoles = new ArrayList<>();
		List<String> consoleList = new ArrayList<>();
		listoOfConsoles = consoleService.getMappedConsoles(videoGameId);

		for (String consoleId : listoOfConsoles) {
			console = consoleService.getConsole(consoleId);
			consoleList.add(console.getConsoleId() + "|"
					+ console.getConsoleName());
		}
		LOGGER.info("retirieved console list size: " + consoleList.size());
		for (String con : consoleList) {
			LOGGER.info(con);
		}
		return consoleList;
	}

	@RequestMapping(value = "/getMarketPrice", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<String> getMappedMarketValue(
			@RequestParam(value = "videoGameId") String videoGameId,
			@RequestParam(value = "consoleId") String consoleId,
			@RequestParam(value = "conditionId") String conditionId,
			@RequestParam(value = "contentId") String contentId) {
		List<String> resource = new ArrayList<>();
		BigDecimal result = collectionService.getMappedMarketValue(videoGameId,
				consoleId, contentId);
		int collectionId = collectionService.checkIfGameExists(videoGameId,
				consoleId, contentId, conditionId);
		LOGGER.info("Value retrieved from checkIfGameExists : "+collectionId);
		resource.add(result.toString());
		resource.add(Integer.toString(collectionId));
		return resource;
	}

	@RequestMapping(value = "/searchCollectionImpl", method = RequestMethod.POST)
	public String searchUserImpl(
			@ModelAttribute("VideoGameCollection") VideoGameCollection videoGameCollection,
			BindingResult result, ModelMap map) {

		map.addAttribute("VideoGameCollection", new VideoGameCollection());
		List<Object[]> colectionList = collectionService
				.searchGameCollection(videoGameCollection);
		List<String> queryResult = new ArrayList<>();
		for (Object[] row : colectionList) {

			queryResult.add((int) row[0] + "|" + (String) row[1] + "|"
					+ (String) row[2] + "|" + (String) row[3] + "|"
					+ (String) row[4] + "|" + (Date) row[5] + "|"
					+ (BigDecimal) row[6] + "|"
					+ (Double) row[7]);
		}

		if (colectionList.isEmpty()) {
			map.addAttribute("SearchResult", "No Search Results Found");
		}
		map.addAttribute("colectionList", queryResult);
		map.addAttribute("videoGameList", getListOfVideoGames());
		map.addAttribute("consoleList", getListOfConsoles());
		map.addAttribute("conditionList", getListOfGameCondition());
		map.addAttribute("contentList", getListOfGameContents());
		return "LandingPage";
	}

	@RequestMapping(value = "/addNewGameImpl", method = RequestMethod.POST)
	public String addNewGame(
			@ModelAttribute("VideoGameCollection") VideoGameCollection gameCollection,
			BindingResult result, ModelMap map) {
		gameCollection.setPurchaseDate(new Date());
		LOGGER.info("conditionId : " + gameCollection.getConditionId());
		LOGGER.info("consoleId : " + gameCollection.getConsoleId());
		LOGGER.info("contentId : " + gameCollection.getContentId());
		LOGGER.info("videoGameId: " + gameCollection.getVideoGameId());
		LOGGER.info("collectionId: " + gameCollection.getCollectionId());
		LOGGER.info("purchasePrice: " + gameCollection.getPurchasePrice());
		LOGGER.info("purchaseDate: " + gameCollection.getPurchaseDate());
		
		collectionService.addToGameCollection(gameCollection);
		VideoGameCollection videoGameCollection = collectionService.getPersistedRecord(gameCollection.getVideoGameId(),
				gameCollection.getConsoleId(), gameCollection.getContentId(),
				gameCollection.getConditionId());
		
		map.addAttribute("videoGameCollection", videoGameCollection);
		return "LandingPage";
	}

}
