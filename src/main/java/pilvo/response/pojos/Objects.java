package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Objects {

	@JsonProperty("city")
	private String city;

	@JsonProperty("country")
	private String country;

	@JsonProperty("lata")
	private String lata;

	@JsonProperty("mms_enabled")
	private Boolean mms_enabled;

	@JsonProperty("mms_rate")
	private String mms_rate;

	@JsonProperty("monthly_rental_rate")
	private String monthly_rental_rate;

	@JsonProperty("number")
	private String number;

	@JsonProperty("prefix")
	private String prefix;

	@JsonProperty("prerequisites")
	private Object prerequisites;

	@JsonProperty("rate_center")
	private String rate_center;

	@JsonProperty("region")
	private String region;

	@JsonProperty("resource_uri")
	private String resource_uri;

	@JsonProperty("restriction")
	private String restriction;

	@JsonProperty("restriction_text")
	private String restriction_text;

	@JsonProperty("setup_rate")
	private String setup_rate;

	@JsonProperty("sms_enabled")
	private Boolean sms_enabled;

	@JsonProperty("sms_rate")
	private String sms_rate;

	@JsonProperty("sub_type")
	private String sub_type;

	@JsonProperty("type")
	private String type;

	@JsonProperty("voice_enabled")
	private Boolean voice_enabled;

	@JsonProperty("voice_rate")
	private String voice_rate;

}
