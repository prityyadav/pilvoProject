package pilvo.response.pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PhoneNmber {

	@JsonProperty("api_id")
	private String api_id;

	@JsonProperty()
	private Meta meta;

	@JsonProperty()
	private List<Objects> objects;

}
