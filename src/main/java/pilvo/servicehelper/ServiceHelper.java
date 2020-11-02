package pilvo.servicehelper;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Response;

import pilvo.businesslogic.CountryToISOMapping;
import pilvo.common.utils.Constants;
import pilvo.common.utils.DataManager;

public class ServiceHelper {

	static Response response;

	public static Response getResponseAllNumbers() {

		try {
			response = given().authentication()
					.basic(DataManager.getInstance().getAuthId(), DataManager.getInstance().getAuthToken()).when().log()
					.all()
					.get(DataManager.getInstance().getBaseUrl() + Constants.ENDPOINTS
							+ DataManager.getInstance().getAuthId() + Constants.GETPHONENUMBERS)
					.then().extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public static Response sendMessagesToNumbers(Object body) {

		try {
			response = given().authentication()
					.basic(DataManager.getInstance().getAuthId(), DataManager.getInstance().getAuthToken()).body(body)
					.contentType("application/json").when().log().all()
					.post(DataManager.getInstance().getBaseUrl() + Constants.ENDPOINTS
							+ DataManager.getInstance().getAuthId() + Constants.SENDMESSAGES)
					.then().extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public static Response getRetrieveMessage(String msg_uuid) {

		try {
			response = given().authentication()
					.basic(DataManager.getInstance().getAuthId(), DataManager.getInstance().getAuthToken()).when().log()
					.all()
					.get(DataManager.getInstance().getBaseUrl() + Constants.ENDPOINTS
							+ DataManager.getInstance().getAuthId() + Constants.SENDMESSAGES + msg_uuid)
					.then().extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public static Response getPriceForCountry(String country) {

		try {
			response = given().authentication()
					.basic(DataManager.getInstance().getAuthId(), DataManager.getInstance().getAuthToken())
					.queryParam("country_iso", CountryToISOMapping.countryISOMap(country)).when().log().all()
					.get(DataManager.getInstance().getBaseUrl() + Constants.ENDPOINTS
							+ DataManager.getInstance().getAuthId() + Constants.PRICINGSERVICE)
					.then().extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	public static Response getAccountDeatils() {

		try {
			response = given().authentication()
					.basic(DataManager.getInstance().getAuthId(), DataManager.getInstance().getAuthToken()).when().log()
					.all().get(DataManager.getInstance().getBaseUrl() + Constants.ENDPOINTS
							+ DataManager.getInstance().getAuthId())
					.then().extract().response();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
