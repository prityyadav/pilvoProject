package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccountDetails {

	@JsonProperty("account_type")
	private String account_type;

	@JsonProperty("address")
	private String address;

	@JsonProperty("api_id")
	private String api_id;

	@JsonProperty("auth_id")
	private String auth_id;

	@JsonProperty("auto_recharge")
	private String auto_recharge;

	@JsonProperty("billing_mode")
	private String billing_mode;

	@JsonProperty("cash_credits")
	private String cash_credits;

	@JsonProperty("city")
	private String city;

	@JsonProperty("name")
	private String name;

	@JsonProperty("resource_uri")
	private String resource_uri;

	@JsonProperty("state")
	private String state;

	@JsonProperty("timezone")
	private String timezone;

}
