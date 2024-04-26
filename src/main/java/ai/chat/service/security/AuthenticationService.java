package ai.chat.service.security;

import ai.chat.dto.JwtAuthenticationResponse;
import ai.chat.dto.UserDto;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(UserDto request);

  JwtAuthenticationResponse signin(UserDto request);
}
