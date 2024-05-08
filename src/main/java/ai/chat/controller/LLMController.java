package ai.chat.controller;
import ai.chat.client.LLMClient;
import ai.chat.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/chat")
public class LLMController {

    private final LLMClient freeLLMClient;
    private final LLMClient paidLLMClient;

    @Autowired
    public LLMController(@Qualifier("FreeLLM") LLMClient freeLLMClient,
                         @Qualifier("PaidLLM") LLMClient paidLLMClient) {
        this.freeLLMClient = freeLLMClient;
        this.paidLLMClient = paidLLMClient;
    }

    @PostMapping("/generate/free")
    public ResponseDTO generateFreeResponse(@RequestBody ResponseDTO request)
            throws JsonProcessingException {
        return freeLLMClient.generateResponse(request.getResponse(), request.getContext());
    }

    @PostMapping("/generate/paid")
    public ResponseDTO generatePaidResponse(@RequestBody ResponseDTO request)
            throws JsonProcessingException {
        return paidLLMClient.generateResponse(request.getResponse(), request.getContext());
    }
}
