package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserNumberDetails {

	@JsonProperty("number")
	private String number;

	@JsonProperty("country")
	private String country;

}
