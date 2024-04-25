package ai.chat.controller;

import ai.chat.dto.UserDto;
import ai.chat.dto.UserNameDto;
import ai.chat.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
@AllArgsConstructor
public class ChatController {

  public UserService userService;

  @PostMapping()
  public ResponseEntity<String> createFunnelRemoteWrite(
      @RequestBody UserDto userDto
      ) {
    userService.createUser(userDto);
    return ResponseEntity.ok("OKAY");
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserNameDto>> getAllUsers() {
    List<UserNameDto> users = userService.getAll();
    return ResponseEntity.ok(users);
  }
}
