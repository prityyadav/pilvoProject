package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Pricing {

	@JsonProperty("country")
	private String country;

	@JsonProperty("country_code")
	private Integer country_code;

	@JsonProperty("country_iso")
	private String country_iso;

	@JsonProperty()
	private Message message;

}
