package ai.chat.controller;

import ai.chat.service.*;
import ai.chat.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserRequestService userRequestService;

    @PostMapping("/{id}")
    public UserResponseDto passRequest(@PathVariable String id) {
        UserResponseDto userResponseDto = userRequestService.receiveMessage(id);
        return userResponseDto;
    }
}
