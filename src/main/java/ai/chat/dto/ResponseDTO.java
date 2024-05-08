package ai.chat.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDTO {
    private String response;
    private ArrayList<Integer> context;

    @JsonCreator
    public ResponseDTO(@JsonProperty("prompt") String response,
                       @JsonProperty("context") ArrayList<Integer> context) {
        this.response = response;
        this.context = context;
    }
}
