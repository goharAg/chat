package ai.chat.controller;
import ai.chat.dto.MessageResponseDto;
import ai.chat.service.ChatService;
import ai.chat.dto.MessageRequestDto;
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
    public MessageResponseDto generateFreeResponse(@RequestBody MessageRequestDto request)
        throws JsonProcessingException{
        return chatService.callFreeModel(request);
    }

    @PostMapping("/generate/premium")
    public MessageResponseDto generatePremiumResponse(@RequestBody MessageRequestDto request)
            throws JsonProcessingException {
        return chatService.callPremiumModel(request);
    }
}
