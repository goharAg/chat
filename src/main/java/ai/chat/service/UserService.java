package ai.chat.service;

import ai.chat.dto.UserDto;
import ai.chat.dto.UserNameDto;
import ai.chat.model.AccountType;
import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  public UserRepository userRepository;

  public User createUser(UserDto userDto){
    User user = User.builder()
        .username(userDto.getUsername())
        .password(userDto.getPassword())
        .accountType(AccountType.FREE)
        .build();

    userRepository.save(user);
    return user;
  }

  public List<UserNameDto> getAll(){
    List<User> users = userRepository.findAll();

    return users.stream()
        .map(user -> UserNameDto.builder().username(user.getUsername()).build())
        .toList();
  }
}
