package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Outbound {

	@JsonProperty("rate")
	private String rate;

}
