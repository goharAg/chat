package ai.chat.controller;

import ai.chat.dto.JwtAuthenticationResponse;
import ai.chat.dto.UserDto;
import ai.chat.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;
  @PostMapping("/signup")
  public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody UserDto request) {
    return ResponseEntity.ok(authenticationService.signup(request));
  }

  @PostMapping("/login")
  public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody UserDto request) {
    return ResponseEntity.ok(authenticationService.signin(request));
  }
}
