package pilvo.response.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Meta {

	@JsonProperty("limit")
	private Integer limit;

	@JsonProperty("next")
	private String next;

	@JsonProperty("offset")
	private Integer offset;

	@JsonProperty("total_count")
	private Integer total_count;

}
