package ai.chat.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Data
@Builder
public class ErrorResponse {

  private String message;

  private HttpStatus status;
}
