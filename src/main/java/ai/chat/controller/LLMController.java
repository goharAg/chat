package ai.chat.controller;
import ai.chat.service.ChatService;
import ai.chat.dto.MessageDTO;
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
    public MessageDTO generateFreeResponse(@RequestBody MessageDTO request)
        throws JsonProcessingException{
        return chatService.callFreeModel(request);
    }

    @PostMapping("/generate/premium")
    public MessageDTO generatePremiumResponse(@RequestBody MessageDTO request)
            throws JsonProcessingException {
        return chatService.callPremiumModel(request);
    }
}
