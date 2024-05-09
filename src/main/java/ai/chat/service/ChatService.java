package ai.chat.service;
import ai.chat.client.*;
import ai.chat.dto.MessageRequestDto;
import ai.chat.dto.MessageResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final LLMClient freeLLMClient;
    private final LLMClient premiumLLMClient;

    @Autowired
    public ChatService(@Qualifier("FreeLLM") LLMClient freeLLMClient,
                       @Qualifier("PremiumLLM") LLMClient premiumLLMClient) {
        this.freeLLMClient = freeLLMClient;
        this.premiumLLMClient = premiumLLMClient;
    }

    public MessageResponseDto callFreeModel(MessageRequestDto request) throws JsonProcessingException {
        return freeLLMClient.generateResponse(request.getPrompt(), request.getContext());
    }

    public MessageResponseDto callPremiumModel(MessageRequestDto request) throws JsonProcessingException {
        return premiumLLMClient.generateResponse(request.getPrompt(), request.getContext());
    }

}
