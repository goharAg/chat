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
public class MessageRequestDto {
    private String prompt;
    private ArrayList<Integer> context;

    @JsonCreator
    public MessageRequestDto(@JsonProperty("prompt") String prompt,
                             @JsonProperty("context") ArrayList<Integer> context) {
        this.prompt = prompt;
        this.context = context;
    }
}
