package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Message {

	@JsonProperty("inbound")
	private Inbound inbound;

	@JsonProperty("outbound")
	private Outbound outbound;

}
