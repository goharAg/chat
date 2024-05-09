package ai.chat.service.security;

import ai.chat.dto.JwtAuthenticationResponse;
import ai.chat.dto.RegistrationDto;
import ai.chat.model.AccountType;
import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import ai.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  @Override
  public JwtAuthenticationResponse signup(RegistrationDto request) {
    var user = User.builder().username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .accountType(AccountType.FREE).build();

    String id = userService.createUser(request);
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).id(id).build();
  }

  @Override
  public JwtAuthenticationResponse signin(RegistrationDto request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    var user = userService.getUserById(request.getUsername());
    if(user.isEmpty()){
        throw new IllegalArgumentException("Invalid email or password");
    }
    var jwt = jwtService.generateToken(user.get());
    return JwtAuthenticationResponse.builder().token(jwt).id(user.get().getId()).build();
  }
}
