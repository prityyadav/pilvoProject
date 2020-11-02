package pilvo.response.pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SendMessage {

	@JsonProperty("api_id")
	private String api_id;

	@JsonProperty("message")
	private String message;

	@JsonProperty("message_uuid")
	private List<String> message_uuid;

}
