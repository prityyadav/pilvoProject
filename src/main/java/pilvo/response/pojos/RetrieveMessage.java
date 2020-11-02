package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class RetrieveMessage {

	@JsonProperty("api_id")
	private String api_id;

	@JsonProperty("error_code")
	private String error_code;

	@JsonProperty("from_number")
	private String from_number;

	@JsonProperty("message_direction")
	private String message_direction;

	@JsonProperty("message_state")
	private String message_state;

	@JsonProperty("message_time")
	private String message_time;

	@JsonProperty("message_type")
	private String message_type;

	@JsonProperty("message_uuid")
	private String message_uuid;

	@JsonProperty("resource_uri")
	private String resource_uri;

	@JsonProperty("to_number")
	private String to_number;

	@JsonProperty("total_amount")
	private String total_amount;

	@JsonProperty("total_rate")
	private String total_rate;

	@JsonProperty("units")
	private String units;

}
