package ai.chat.dto;

import ai.chat.model.AccountType;

public class UserResponseDto {
    private String id;
    private String username;
    private AccountType accountType;

    public UserResponseDto(String id, String username, AccountType accountType) {
        this.id = id;
        this.username = username;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {  return username;}

    public AccountType getAccountType() {
        return accountType;
    }
}
