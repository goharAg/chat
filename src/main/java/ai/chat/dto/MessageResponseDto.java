package ai.chat.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageResponseDto {

  @JsonProperty("response")
  private String response;
  @JsonProperty("context")
  private ArrayList<Integer> context;

  @JsonCreator
  public MessageResponseDto(@JsonProperty("response") String response,
                           @JsonProperty("context") ArrayList<Integer> context) {
    this.response = response;
    this.context = context;
  }
}
