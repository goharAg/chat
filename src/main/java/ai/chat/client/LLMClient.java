package ai.chat.client;

import ai.chat.dto.MessageResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class LLMClient {
    private static final Logger logger = LoggerFactory.getLogger(LLMClient.class);
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String model;


    public MessageResponseDto generateResponse(String prompt, ArrayList<Integer> context)
            throws JsonProcessingException {
        String url = baseUrl + "/api/generate";
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("model", model);
        payloadMap.put("prompt", prompt);
        payloadMap.put("context", context != null ? context : new ArrayList<Integer>(0));
        payloadMap.put("stream", false);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(payloadMap), headers);
        try {
            String jsonResponse = restTemplate.postForObject(url, entity, String.class);
            return mapper.readValue(jsonResponse, MessageResponseDto.class);
        } catch (JsonProcessingException e) {
            logger.error("Error generating JSON payload: {}", e.getMessage(), e);
            throw new RuntimeException("Error generating JSON payload", e);
        } catch (Exception e) {
            logger.error("Error during HTTP call or parsing response: {}", e.getMessage(), e);
            throw new RuntimeException("Error communicating with Ollama service", e);
        }
    }
}

