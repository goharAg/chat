package ai.chat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class UserRequestDto {
  private String id;

  public String getId() {
    return id;
  }

}