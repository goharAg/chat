package ai.chat.dto;

import ai.chat.model.AccountType;

public class UserResponseDto {
    private String id;
    private AccountType accountType;

    public UserResponseDto(String id, AccountType accountType) {
        this.id = id;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}
