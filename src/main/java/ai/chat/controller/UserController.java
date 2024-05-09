package ai.chat.controller;

import ai.chat.service.*;
import ai.chat.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userRequestService;

    @GetMapping("/{id}")
    public UserInfoDto passRequest(@PathVariable String id) {
        UserInfoDto userResponseDto = userRequestService.getUserInfo(id);
        return userResponseDto;
    }


}
