package ai.chat.config;

import ai.chat.client.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class LLMConfiguration {

    @Value("${ollama.base-url}")
    private String baseUrl;

    @Value("${ollama.model.free}")
    private String freeModel;

    @Value("${ollama.model.paid}")
    private String paidModel;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    @Qualifier("FreeLLM")
    public LLMClient freeLLM(RestTemplate restTemplate) {
        return new LLMClient(restTemplate, baseUrl, freeModel);
    }

    @Bean
    @Qualifier("PremiumLLM")
    public LLMClient paidLLM(RestTemplate restTemplate) {
        return new LLMClient(restTemplate, baseUrl, paidModel);
    }

}

