package pilvo.common.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataManager {

	private static DataManager dataManager;
	private Properties prop;

//	private static String env;
//	private static String authId;
//	private static String authToken;

	private DataManager() {

		prop = new Properties();

		String fileName = "config.properties";

		InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			is = new FileInputStream(fileName);

		} catch (FileNotFoundException ex) {

		}
		try {
			prop.load(is);
		} catch (IOException ex) {

		}
	}

	public static DataManager getInstance() {
		if (dataManager == null) {
			dataManager = new DataManager();
		}
		return dataManager;
	}

	public String getBaseUrl() {
		String baseUrl = prop.getProperty(Constants.BaseUrl);
		if (baseUrl != null)
			return baseUrl;
		else
			throw new RuntimeException("base_Url not specified in the Configuration.properties file.");
	}

	public String getAuthId() {
		String authId = prop.getProperty(Constants.AuthId);
		if (authId != null)
			return authId;
		else
			throw new RuntimeException("AuthId not specified in the Configuration.properties file.");
	}

	public String getAuthToken() {
		String authToken = prop.getProperty(Constants.AuthToken);
		if (authToken != null)
			return authToken;
		else
			throw new RuntimeException("AuthToken not specified in the Configuration.properties file.");
	}

	public String getTextMsg() {
		String text = prop.getProperty(Constants.text);
		if (text != null)
			return text;
		else
			throw new RuntimeException("Text not specified in the Configuration.properties file.");

	}
}
