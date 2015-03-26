package edu.uta.vgame.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * @author Sandeep_Raikar
 * 
 */
public class Constants {


	public static final String QUERY1;
	public static final String QUERY2;
	public static final String QUERY3;
	public static final String QUERY4;
	public static final String QUERY5;
	public static final String QUERY6;
	public static final String QUERY7;
	
	
	static {

		Configuration config = null;
		try {
			config = new PropertiesConfiguration("resources/config.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

		QUERY1 = config.getString("query1.output");
		QUERY2 = config.getString("query2.output");
		QUERY3 = config.getString("query3.output");
		QUERY4 = config.getString("query4.output");
		QUERY5 = config.getString("query5.output");
		QUERY6 = config.getString("query6.output");
		QUERY7 = config.getString("query7.output");
		
	}
}
