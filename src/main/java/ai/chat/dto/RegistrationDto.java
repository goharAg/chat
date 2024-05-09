package ai.chat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class RegistrationDto {
  private String username;
  private String password;
  private boolean premium;
}
