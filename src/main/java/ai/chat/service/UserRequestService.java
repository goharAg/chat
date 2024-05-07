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

    public UserResponseDto getUserInfo(String id) {
        User user = userRepository.findByUserId(id);
        AccountType accountType = user.getAccountType();
        String username = user.getUsername();
        UserResponseDto userResponse = new UserResponseDto(id, username, accountType);
        return userResponse;
    }

    public boolean isFree(String id) {
        User user = userRepository.findByUserId(id);
        AccountType accountType = user.getAccountType();
        if (accountType == AccountType.FREE) {
            return true;
        }
        return false;
    }

    public boolean isPremium(String id) {
        User user = userRepository.findByUserId(id);
        AccountType accountType = user.getAccountType();
        if (accountType == AccountType.PREMIUM) {
            return true;
        }
        return false;
    }


}