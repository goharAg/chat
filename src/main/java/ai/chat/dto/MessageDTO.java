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
public class MessageDTO {
    private String message;
    private ArrayList<Integer> context;

    @JsonCreator
    public MessageDTO(@JsonProperty("prompt") String message,
                      @JsonProperty("context") ArrayList<Integer> context) {
        this.message = message;
        this.context = context;
    }
}
