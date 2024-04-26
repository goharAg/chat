package ai.chat.service.security;

import ai.chat.dto.JwtAuthenticationResponse;
import ai.chat.dto.UserDto;
import ai.chat.model.AccountType;
import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  @Override
  public JwtAuthenticationResponse signup(UserDto request) {
    var user = User.builder().username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .accountType(AccountType.FREE).build();
    userRepository.save(user);
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).build();
  }

  @Override
  public JwtAuthenticationResponse signin(UserDto request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    var user = userRepository.findByUsername(request.getUsername());
    if(user == null){
        throw new IllegalArgumentException("Invalid email or password");
    }
    var jwt = jwtService.generateToken(user);
    return JwtAuthenticationResponse.builder().token(jwt).build();
  }
}
