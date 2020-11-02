package pilvo.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;

import lombok.NonNull;

public class CommonUtils {

	static ObjectMapper objectMapper = new ObjectMapper();

	// Object Mapper Method
	public static <T> T deserialize(Response response, @NonNull Class<T> clazz) {

		try {
			return objectMapper.readValue(response.body().asString(), clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);

		}

	}

}
