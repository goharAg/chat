package ai.chat.service.security;

import ai.chat.dto.JwtAuthenticationResponse;
import ai.chat.dto.RegistrationDto;
import ai.chat.dto.UserDto;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(RegistrationDto request);

  JwtAuthenticationResponse signin(RegistrationDto request);
}
