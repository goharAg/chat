package ai.chat.controller;
import ai.chat.service.ChatService;
import ai.chat.dto.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class LLMController {

    private ChatService chatService;
    public LLMController(ChatService service) {
        chatService = service;
    }

    @PostMapping("/generate/free")
    public ResponseDTO generateFreeResponse(@RequestBody ResponseDTO request) throws JsonProcessingException{
        return chatService.callFreeModel(request);
    }

    @PostMapping("/generate/premium")
    public ResponseDTO generatePremiumResponse(@RequestBody ResponseDTO request)
            throws JsonProcessingException {
        return chatService.callPremiumModel(request);
    }
}
