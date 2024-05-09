package ai.chat.service;

import ai.chat.model.AccountType;
import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ai.chat.dto.*;

@Service
@AllArgsConstructor
public class UserService {
    public UserRepository userRepository;

    public UserInfoDto getUserInfo(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            AccountType accountType = user.get().getAccountType();
            String username = user.get().getUsername();
            return new UserInfoDto(id, username, accountType);

        }else{
            throw new RuntimeException("so user found");
        }
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public boolean isPremium(String id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            AccountType accountType = user.get().getAccountType();
           return accountType == AccountType.PREMIUM;
        } else {
            return false;
        }

    }

    public String createUser(UserDto userDto){
        User existingUser = userRepository.findByUsername(userDto.getUsername());
        if(existingUser != null){
            throw new IllegalArgumentException("User already exists");
        }
        User user = User.builder()
            .username(userDto.getUsername())
            .password(userDto.getPassword())
            .accountType(AccountType.FREE)
            .build();
        userRepository.save(user);
        return user.getId();
    }

    public String createUser(RegistrationDto registrationDto){
        User existingUser = userRepository.findByUsername(registrationDto.getUsername());
        if(existingUser != null){
            throw new IllegalArgumentException("User already exists");
        }
        AccountType accountType = registrationDto.isPremium() ?
            AccountType.PREMIUM : AccountType.FREE;
        User user = User.builder()
            .username(registrationDto.getUsername())
            .password(registrationDto.getPassword())
            .accountType(accountType)
            .build();
        userRepository.save(user);
        return user.getId();
    }

    public List<UserNameDto> getAll(){
        List<User> users = userRepository.findAll();

        return users.stream()
            .map(user -> UserNameDto.builder().username(user.getUsername()).build())
            .toList();
    }
}