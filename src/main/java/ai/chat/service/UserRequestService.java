package ai.chat.service;

import ai.chat.model.AccountType;
import ai.chat.model.User;
import ai.chat.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ai.chat.dto.*;

@Service
@AllArgsConstructor
public class UserRequestService {
    public UserRepository userRepository;

    public UserResponseDto receiveMessage(String id) {
        AccountType accountType = checkAccountType(id);
        UserResponseDto userResponse = new UserResponseDto(id, accountType);
        //if type is free pass to one model, if premium to another
        return userResponse;
    }
    public AccountType checkAccountType(String id) {
        User user = userRepository.findByUserId(id);
        return user.getAccountType();
    }
}