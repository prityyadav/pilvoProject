package pilvo.businesslogic;

import java.util.HashMap;

public class CountryToISOMapping {

	// All the countrywise Country ISO are mapped here.
	static HashMap<String, String> countryISOMap = new HashMap<String, String>();

	public static String countryISOMap(String key) {

		countryISOMap.put("United States", "US");
		countryISOMap.put("Turkey", "TR");
		countryISOMap.put("India", "IN");
		countryISOMap.put("Indonesia", "ID");
		countryISOMap.put("Hong Kong", "HK");

		return countryISOMap.get(key);

	}

}