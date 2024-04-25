package ai.chat.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@Builder
@Data
public class User {
  @Id
  private String id;
  private String username;
  private String password;
  private AccountType accountType;

  // Constructors, getters, and setters
}

